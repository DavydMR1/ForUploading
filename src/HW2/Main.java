package HW2;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Tom", "fleas");
        Eagle eagle = new Eagle("Innokenty", "broken wing");
        Turtle turtle = new Turtle("Natasha", "none, planned checkup");
        Duck duck = new Duck("NONE", "drunk");
        VetClinic vetClinic = new VetClinic();
        Doctor doctor = new Doctor();
        vetClinic.addpatients(cat, eagle, turtle, duck);
        System.out.println(vetClinic.getPatients());
        System.out.println(vetClinic.getgoables());
        System.out.println(vetClinic.getswimmables());
        System.out.println(vetClinic.getflyables());
        System.out.println(doctor.DoCheckup());
    }
}