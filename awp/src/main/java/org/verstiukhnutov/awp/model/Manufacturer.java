package org.verstiukhnutov.awp.model;

import org.verstiukhnutov.awp.model.error.InvalidManufacturerNameException;

public class Manufacturer {

    public enum ManufacturerType {
        Tov,
        Fop,
        Pp,
        Gmbh,
        Llc,
        Univ;

        @Override
        public String toString() {
            switch (this) {
                case Tov: return "ТОВ";
                case Fop: return "ФОП";
                case Pp: return "ПП";
                case Gmbh: return "GmbH";
                case Llc: return "LLC";
                case Univ: return "Національний університет";
                default: return "<невизначено>";
            }
        }
    };

    private ManufacturerType type;
    private ManufacturerName name;

    public Manufacturer() {
        this.name = new ManufacturerName();
        this.type = ManufacturerType.Tov;
    }

    public Manufacturer(ManufacturerType type, ManufacturerName name) throws InvalidManufacturerNameException {
        this.name = name;
        this.type = type;
    }

    public ManufacturerType getType() {
        return type;
    }

    public void setType(ManufacturerType type) {
        this.type = type;
    }

    public ManufacturerName getName() {
        return name;
    }

    public void setName(ManufacturerName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return type + " " + name;
    }
    
}
