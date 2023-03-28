public class Test {
    public static void main(String[]args){

        ArrayList<Property> propertyDB = new ArrayList<Property>();

            Property prop1 = new Office(120, 30, 4, true, classification.SERVICE);

            propertyDB.add (prop1);

            Property prop2 = new Farm(250, 3400, "vegetables");
            propertyDB.add(prop2);
            System.out.println(compareTo(prop1,prop2));

            Property prop3 = new House(125, 300, 2, 10, 20, HouseType.DETACHED );

            propertyDB.add (prop3);

            Property prop4 = new Cottage(215, 200, 0, 5, 30, 10, 0);
            propertyDB.add(prop4);
            System.out.println(compareTo(prop3,prop4));

            Property prop5 = new ApartmentBuilding(125, 0, 2, 10, 4);

            propertyDB.add (prop5);

            Property prop6 = new Farm(215, 200, null);
            propertyDB.add(prop6);
            System.out.println(compareTo(prop5,prop6));

            Property prop7 = new Office(125, 300, 0, false, classification.INDUSTRIAL);

            propertyDB.add (prop7);

            Property prop8 = new Cottage(215, 200, 3, 5, 30, 10, 4);
            propertyDB.add(prop8);
            System.out.println(compareTo(prop5,prop6));


            
}}
