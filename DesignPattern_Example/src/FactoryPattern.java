public class FactoryPattern extends DesignPattern_Template
{
    FactoryPattern(){
        pattern_name = "Factory Pattern";
        pattern_description = " This type of design pattern comes under creational pattern as this pattern \n" +
                "provides one of the best ways to create an object.";
    }




}

interface Toy{
    void whatToy();
}

class ToyFactory{
    public Toy getToy(String toyType){
        if (toyType == null) {
            return null;
        }
        switch (toyType){
            case "Child":
                return new childToy();
            case "Senior":
                return new seniorToy();
            case "Elder":
                return new elderToy();
        }
        return null;
    }
}



class childToy implements Toy{
    @Override
    public void whatToy() {
        System.out.println("Returning childToy::WhatToy method ");
    }
}
class seniorToy implements Toy{

    @Override
    public void whatToy() {
        System.out.println("Returning seniorToy::WhatToy method ");
    }
}

class elderToy implements Toy{

    @Override
    public void whatToy() {
        System.out.println("Returning elderToy::WhatToy method ");
    }
}