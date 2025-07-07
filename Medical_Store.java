import java.util.Scanner;

class Medicine {
    String name;
    int quantity;
	String medicine_id;
	String company;
	String date_of_purchase;
	String date_of_expiry;

    public Medicine(String name, int quantity, String medicine_id, String company, String date_of_purchase, String date_of_expiry){
        this.name = name;
        this.quantity = quantity;
		this.medicine_id = medicine_id;
		this.company = company;
		this.date_of_purchase = date_of_purchase;
		this.date_of_expiry = date_of_expiry;
    }
}

class Inventory {
    Medicine[] medicines;
    int count;

    public Inventory() {
        medicines = new Medicine[100];
        count = 0;
    }

    public void addMedicine(String name, int quantity, String medicine_id, String company, String date_of_purchase, String date_of_expiry) {
        medicines[count] = new Medicine(name, quantity, medicine_id, company, date_of_purchase, date_of_expiry);
        count++;
        System.out.println("Medicine added to inventory");
		System.out.println("");
    }

    public void sellMedicine(String name, int quantityToSell) {
        for (int i = 0; i < count; i++) {
            if (medicines[i].name.equals(name)) {
                if (medicines[i].quantity >= quantityToSell) {
                    medicines[i].quantity -= quantityToSell;
                    System.out.println("Medicine sold");
                } else {
                    System.out.println("Medicine not available in sufficient quantity");
                }
                return;
            }
        }
        System.out.println("Medicine not found in inventory");
    }
	
	public void updateMedicine(String medicineId, int newQuantity) {
        for (int i = 0; i < count; i++) {
            if (medicines[i].medicine_id.equals(medicineId)) {
                medicines[i].quantity = newQuantity;
                System.out.println("Medicine updated");
                return;
            }
        }
        System.out.println("Medicine not found in inventory");
    }
	
	
    public void displayInventory() {
		System.out.println("");
        System.out.println("Inventory:");
        for (int i = 0; i < count; i++) {
			System.out.println("");
            System.out.println("Name: "+medicines[i].name);
			System.out.println("Quantity: "+medicines[i].quantity);
			System.out.println("ID: "+medicines[i].medicine_id);
			System.out.println("Company: "+medicines[i].company);
			System.out.println("Date of Purchase: "+medicines[i].date_of_purchase);
			System.out.println("Date of Expiry: "+medicines[i].date_of_expiry);
			System.out.println("");
		}
    }
}

class MedicalStore {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add medicine");
			System.out.println("2. Sell Medicine");
			System.out.println("3. Display Inventory");
			System.out.println("4. Update Medicine");
			System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
					System.out.println("");
                    System.out.print("Enter medicine name: ");
                    String medicine = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
					System.out.print("Enter Medicine ID: ");
					String medicine_id = scanner.next();
					scanner.nextLine();
					System.out.print("Enter Company: ");
					String company = scanner.next();
					System.out.print("Enter Date of Purchase: ");
					String date_of_purchase = scanner.next();
					System.out.print("Enter Date of Expiry: ");
					String date_of_expiry = scanner.next();
					System.out.println("");
					
                    inventory.addMedicine(medicine, quantity, medicine_id, company, date_of_purchase, date_of_expiry);
                    break;
                case 2:
                    System.out.print("Enter medicine name: ");
                    String medicineToSell = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantityToSell = scanner.nextInt();
                    inventory.sellMedicine(medicineToSell, quantityToSell);
                    break;
                case 3:
                    inventory.displayInventory();
                    break;
				case 4:
					System.out.print("Enter medicine ID to update: ");
                    String medicineIdToUpdate = scanner.next();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    inventory.updateMedicine(medicineIdToUpdate, newQuantity);
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}