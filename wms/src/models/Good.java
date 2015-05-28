package models;

import com.et.ar.ActiveRecordBase;
import com.et.ar.annotations.BelongsTo;
import com.et.ar.annotations.Column;
import com.et.ar.annotations.Id;
import com.et.ar.annotations.Table;

@Table(name="goods")
public class Good extends ActiveRecordBase{
    @Id private Integer id;
    @Column private Integer goodTypeId;
    @Column private String code;
    @Column private String name;
    @Column private String remark;
    @Column private String unit;
    @Column private String model;
    @Column private String spec;
    @Column private String color;
    @Column private String brand;
    @Column private String place;
    @Column private String vender;
    @Column private String barcode;
    @Column private Integer countUp;
    @Column private Integer countDown;
    @Column private String help;
    
    @BelongsTo(foreignKey="goodTypeId")
    private GoodType goodType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getVender() {
        return vender;
    }

    public void setVender(String vender) {
        this.vender = vender;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }


    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    /**
     * @return the goodTypeId
     */
    public Integer getGoodTypeId() {
        return goodTypeId;
    }

    /**
     * @param goodTypeId the goodTypeId to set
     */
    public void setGoodTypeId(Integer goodTypeId) {
        this.goodTypeId = goodTypeId;
    }

    /**
     * @return the countUp
     */
    public Integer getCountUp() {
        return countUp;
    }

    /**
     * @param countUp the countUp to set
     */
    public void setCountUp(Integer countUp) {
        this.countUp = countUp;
    }

    /**
     * @return the countDown
     */
    public Integer getCountDown() {
        return countDown;
    }

    /**
     * @param countDown the countDown to set
     */
    public void setCountDown(Integer countDown) {
        this.countDown = countDown;
    }

    /**
     * @return the goodType
     */
    public GoodType getGoodType() {
        return goodType;
    }

    /**
     * @param goodType the goodType to set
     */
    public void setGoodType(GoodType goodType) {
        this.goodType = goodType;
    }

}
