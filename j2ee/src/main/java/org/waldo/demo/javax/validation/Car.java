/**
 * @author waldo.wy
 * @date 2017/3/3
 */
package org.waldo.demo.javax.validation;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Validation验证实体类
 *
 * @author waldo.wangy 2017/3/3 15:03
 */
public class Car {

    @NotNull(message = "没有引擎，车怎么跑呢？")
    private String manufacturer;

    @NotNull
    @Size(min = 2, max = 14, message = "The license plate '${validatedValue}' must be between {min} and {max} characters long")
    private String licensePlate;

    @Min(value = 4, message = "There must be at least {value} seat${value > 1 ? 's' : ''}")
    private int seatCount;

    @DecimalMax(value = "350", message = "The top speed ${formatter.format('%1$.2f', validatedValue)} is higher than {value}")
    private double topSpeed;

    public Car() {
    }

    public Car(String manufacturer, String licensePlate, int seatCount, double topSpeed) {
        this.manufacturer = manufacturer;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.topSpeed = topSpeed;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}
