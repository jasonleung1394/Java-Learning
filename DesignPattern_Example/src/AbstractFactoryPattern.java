public class AbstractFactoryPattern extends DesignPattern_Template{
    AbstractFactoryPattern(){
        pattern_name = "Abstract Factory";
        pattern_description = "Abstract Factory patterns work around a super-factory which creates other factories. \n" +
                " This factory is also called as factory of factories. This type of design pattern comes unde \n" +
                "r creational pattern as this pattern provides one of the best ways to create an object.\n" +
                "\n" +
                "In Abstract Factory pattern an interface is responsible for creating a factory of related objects \n" +
                "without explicitly specifying their classes. Each generated factory can give the objects as per the \n" +
                "Factory pattern.";
    }
    public static AbstractFactory getFactory(String factoryType){
        if (factoryType == null) {
            return null;
        }
        switch (factoryType){
            case "weird":
                return new WeirdToyFactory();
            case "normal":
                return new NormalToyFactoryAF();
            default:
                return null;
        }
    }
}

interface ToyAF{
    void whatToy();
}

class NormalToyFactoryAF extends AbstractFactory{
    public ToyAF getToyAF(String toyType){
        if (toyType == null) {
            return null;
        }
        switch (toyType){
            case "Child":
                return new childToyAF();
            case "Senior":
                return new seniorToyAF();
            case "Elder":
                return new elderToyAF();
        }
        return null;
    }
}
class WeirdToyFactory extends AbstractFactory{
    public ToyAF getToyAF(String toyType){
        if (toyType == null) {
            return null;
        }
        switch (toyType){
            case "Child":
                return new WeirdChildToyAF();
            case "Senior":
                return new WeirdSeniorToyAF();
            case "Elder":
                return new WeirdElderToyAF();
        }
        return null;
    }
}

abstract class AbstractFactory{
    abstract ToyAF getToyAF(String toyType);
}


class childToyAF implements ToyAF{

    @Override
    public void whatToy() {
        System.out.println("Returning childToy::WhatToy method ");
    }
}
class seniorToyAF implements ToyAF{

    @Override
    public void whatToy() {
        System.out.println("Returning seniorToy::WhatToy method ");
    }
}

class elderToyAF implements ToyAF{

    @Override
    public void whatToy() {
        System.out.println("Returning elderToy::WhatToy method ");
    }
}

class WeirdChildToyAF implements ToyAF{

    @Override
    public void whatToy() {
        System.out.println("Returning weird child toy::WhatToy method ");
    }
}
class WeirdSeniorToyAF implements ToyAF{

    @Override
    public void whatToy() {
        System.out.println("Returning weird senior toy::WhatToy method ");
    }
}

class WeirdElderToyAF implements ToyAF{

    @Override
    public void whatToy() {
        System.out.println("Returning weird elder toy::WhatToy method ");
    }
}
