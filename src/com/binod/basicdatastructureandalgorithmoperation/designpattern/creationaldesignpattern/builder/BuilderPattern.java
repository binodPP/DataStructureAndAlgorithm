package com.binod.basicdatastructureandalgorithmoperation.designpattern.creationaldesignpattern.builder;

public class BuilderPattern {
    private String firstName;
    private String lastName;
    private String age;
    private String address;

    private BuilderPattern(BuilderPatternHelper builderPatternHelper) {
        this.firstName = builderPatternHelper.firstName;
        this.lastName = builderPatternHelper.lastName;
        this.age = builderPatternHelper.age;
        this.address = builderPatternHelper.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "BuilderPattern{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class BuilderPatternHelper{
        private String firstName;
        private String lastName;
        //optional
        private String age;
        private String address;

        public BuilderPatternHelper(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }


        public BuilderPatternHelper setAge(String age) {
            this.age = age;
            return this;
        }

        public BuilderPatternHelper setAddress(String address) {
            this.address = address;
            return this;
        }

        public BuilderPattern build(){
           return new BuilderPattern(this);
        }
    }

    public static void main(String[] args) {
        BuilderPattern builderPattern = new BuilderPattern.BuilderPatternHelper("Binod","Singh").
                setAge("35").build();
        System.out.println(builderPattern);
    }
}
