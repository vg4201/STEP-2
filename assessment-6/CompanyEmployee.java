public class CompanyEmployee {

    static class Employee {
        private String empName;
        private double salary;

        private static String companyName =
                "Bright Horizon Technologies";

        private static int employeeCount = 0;

        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: "
                    + employeeCount);
        }
    }

    public static void main(String[] args) {
        Employee employee1 =
                new Employee("Divya", 65000);

        Employee employee2 =
                new Employee("Arjun", 30000);

        Employee employee3 =
                new Employee("Priya", 45000);

        Employee.printCompanyInfo();
    }
}