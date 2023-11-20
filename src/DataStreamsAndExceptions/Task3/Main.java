package DataStreamsAndExceptions.Task3;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(20, "John", 101);
        Course course = new Course("CS101", "Introduction to Programming", "Dr. Smith");
        Enrollment enrollment = new Enrollment(student, course, "2023-11-20");

        serializeEnrollment(enrollment);

        Enrollment deserializedEnrollment = deserializeEnrollment();
        if (deserializedEnrollment != null) {
            System.out.println("Deserialized Enrollment:");
            System.out.println("Student ID: " + deserializedEnrollment.getStudent().getId());
            System.out.println("Course Code: " + deserializedEnrollment.getCourse().getCourseCode());
            System.out.println("Enrollment Date: " + deserializedEnrollment.getEnrollmentDate());
        }
    }

    private static void serializeEnrollment(Enrollment enrollment) {
        try (FileOutputStream fileOut = new FileOutputStream("enrollments.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(enrollment);
            System.out.println("Enrollment serialized and saved to enrollments.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Enrollment deserializeEnrollment() {
        Enrollment enrollment = null;
        try (FileInputStream fileIn = new FileInputStream("enrollments.ser");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            enrollment = (Enrollment) objectIn.readObject();
            System.out.println("Enrollment deserialized from enrollments.ser");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return enrollment;
    }
}
