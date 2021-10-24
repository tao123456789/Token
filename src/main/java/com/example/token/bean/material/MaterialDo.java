package com.example.token.bean.material;

public class MaterialDo {

    int id;
    String material_id;
    String material_name;
    String material_type;
    String material_dw;
    String material_price;
    String material_gys;
    String gys_name;
    String gys_name_tel;
    String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public String getMaterial_type() {
        return material_type;
    }

    public void setMaterial_type(String material_type) {
        this.material_type = material_type;
    }

    public String getMaterial_dw() {
        return material_dw;
    }

    public void setMaterial_dw(String material_dw) {
        this.material_dw = material_dw;
    }

    public String getMaterial_price() {
        return material_price;
    }

    public void setMaterial_price(String material_price) {
        this.material_price = material_price;
    }

    public String getMaterial_gys() {
        return material_gys;
    }

    public void setMaterial_gys(String material_gys) {
        this.material_gys = material_gys;
    }

    public String getGys_name() {
        return gys_name;
    }

    public void setGys_name(String gys_name) {
        this.gys_name = gys_name;
    }

    public String getGys_name_tel() {
        return gys_name_tel;
    }

    public void setGys_name_tel(String gys_name_tel) {
        this.gys_name_tel = gys_name_tel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "MaterialDo{" +
                "id=" + id +
                ", material_id='" + material_id + '\'' +
                ", material_name='" + material_name + '\'' +
                ", material_type='" + material_type + '\'' +
                ", material_dw='" + material_dw + '\'' +
                ", material_price='" + material_price + '\'' +
                ", material_gys='" + material_gys + '\'' +
                ", gys_name='" + gys_name + '\'' +
                ", gys_name_tel='" + gys_name_tel + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
