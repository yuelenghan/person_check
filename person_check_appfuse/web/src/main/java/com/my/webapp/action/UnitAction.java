package com.my.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.my.service.UnitManager;
import com.my.dao.SearchException;
import com.my.model.Unit;
import com.my.webapp.action.BaseAction;

import java.util.List;

public class UnitAction extends BaseAction implements Preparable {
    private UnitManager unitManager;
    private List units;
    private Unit unit;
    private Long id;
    private String query;

    public void setUnitManager(UnitManager unitManager) {
        this.unitManager = unitManager;
    }

    public List getUnits() {
        return units;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String unitId = getRequest().getParameter("unit.id");
            if (unitId != null && !unitId.equals("")) {
                unit = unitManager.get(new Long(unitId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            units = unitManager.search(query, Unit.class);
        } catch (SearchException se) {
            addActionError(se.getMessage());
            units = unitManager.getAll();
        }
        return SUCCESS;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String delete() {
        unitManager.remove(unit.getId());
        saveMessage(getText("unit.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (id != null) {
            unit = unitManager.get(id);
        } else {
            unit = new Unit();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            return "cancel";
        }

        if (delete != null) {
            return delete();
        }

        boolean isNew = (unit.getId() == null);

        unitManager.save(unit);

        String key = (isNew) ? "unit.added" : "unit.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}