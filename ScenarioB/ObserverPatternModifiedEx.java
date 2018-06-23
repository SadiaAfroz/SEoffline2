package ofline2B;






class ObserverPatternModifiedEx {

    public static void main(String[] args) {
        System.out.println("*** Modified Observer Pattern Demo***\n");
        Software sub = new Software();
        Student ob1 = new Student();
        Student ob3 = new Student();
        ClassRepresentative ob2 = new ClassRepresentative(sub);
        sub.subscribe(ob1);
        sub.subscribe(ob3);
        sub.subscribe(ob2);
           String information="Class will start in 23 June :(";
        ob2.informOthers(information);
        System.out.println();
         information="SE offline have to submit within 23 June 11pm";
        ob2.informOthers(information);
        System.out.println();
//unsubscribe ob1 only
        sub.unsubscribe(ob1);
          information="Hello!!! due to World Cup auto is comming";
//Now only ob2 will observe the change
        ob2.informOthers(information);
    }
}
