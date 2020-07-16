package com.test.demo_ibatis.BuilderTest;



public class Car {
    public enum Colors{RED,GREEEN,BLUE,YELLOW}
    public enum Brand{LEX,LABORGENY,FARRAY}
    private Brand brand;
    private String size;
    private Integer length;
    private Colors colors;

    public static class CarBuilder{
        private Brand brand;
        private String size;
        private Integer length;
        private Colors colors;

        public CarBuilder() {
        }
        public CarBuilder brand(Brand brand){
            this.brand=brand;
            return this;
        }
        public CarBuilder size(String size){
            this.size=size;
            return this;
        }
        public CarBuilder length(Integer length){
            this.length=length;
            return this;
        }
        public CarBuilder colors(Colors colors){
            this.colors=colors;
            return this;
        }

        public Car build(){
            return new Car(this);
        }
    }

    private Car(CarBuilder carBuilder) {
        this.brand = carBuilder.brand;
        this.size = carBuilder.size;
        this.length = carBuilder.length;
        this.colors = carBuilder.colors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand=" + brand +
                ", size='" + size + '\'' +
                ", length=" + length +
                ", colors=" + colors +
                '}';
    }
}
