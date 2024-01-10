package question3;

import org.example.Logging;

public class Main {
    public static void main(String[] args) {
        
        //Creating a doctor to show functionality
        Doctor doctor = new Doctor();
        doctor.setDoctorId(187);
        doctor.setSpecialization("Neurologist");
        doctor.setDescription("My name is Sasi, I am a doctor");
        doctor.setStaffId(187);
        doctor.setYearsOfExperience(5);
        doctor.setEmail("Sasi.rachapotu@gmail.com");
        doctor.setFirstName("Sasi");
        doctor.setInsurance(true);
        doctor.setLastname("Rachapotu");
        doctor.setSalary(100000);

        StringBuilder details = getStringBuilder(doctor);

        Logging logging = new Logging();
        logging.logString(details);

        HealthInsurancePlan hp = new Platinum();
        doctor.setInsurancePlan(hp);
        logging.logString("Platinum Monthly Premium: ");
        logging.logString(Double.toString(doctor.getInsurancePlan().computeMonthlyPremium(doctor.getSalary())));

    }

    private static StringBuilder getStringBuilder(Doctor doctor) {
        StringBuilder details = new StringBuilder("Doctor Details: ");
        details.append("Firstname: ");
        details.append(doctor.getFirstName());
        details.append(" lastname: ");
        details.append(doctor.getLastname());
        details.append((" Email: "));
        details.append(doctor.getEmail());
        details.append(" DoctorId: ");
        details.append(doctor.getDoctorId());
        details.append(" Specialization : ");
        details.append(doctor.getSpecialization());
        details.append(" Description : ");
        details.append(doctor.getDescription());
        return details;
    }
}
