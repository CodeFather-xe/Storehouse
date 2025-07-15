package LogicalClasses;

import java.io.*;
import java.util.ArrayList;



public class Administrator {
    private String username;
    private String password;
    static int setID = 1;

    public static final String ActivationKey = "8122024";
    public static ArrayList<Item> computers = new ArrayList<>();
    public static ArrayList<Item> accessories = new ArrayList<>();
    public static ArrayList<Item> officeFurniture = new ArrayList<>();
//    public static ArrayList<OrderClass> Orders = new ArrayList<>();


    /*--------Constructors--------*/
    public Administrator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Administrator(String username) {
        this.username = username;
    }

    public Administrator() {
    }

    /*--------Getter & Setter--------*/
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    /* To Return Total Sells*/
//    public static float getTotalCash() {
//        float totalCash = 0;
//        for (OrderClass X : AdminClass.Orders) {
//            totalCash += X.getTotalPriceOrder();
//        }
//        return totalCash;
//    }


    public static void writeItemToFile(int id, String name, double price, String imagePath, int quantity, String file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write("#ID: " + id);
            writer.newLine();
            writer.write("Name: " + name);
            writer.newLine();
            writer.write("Price: " + price);
            writer.newLine();
            writer.write("Current Quantity: " + quantity);
            writer.newLine();
            writer.write("Image Path: " + imagePath);
            writer.write("---------------------------------------");
            writer.newLine();
        } catch (IOException _) {
        }
    }

    public static void readItemsFromFileToArray(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String name = "";
            int id = 0;
            double price = 0.0;
            int quantity = 0;
            String imagePath = "";
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#ID:")) {
                    id = Integer.parseInt(line.replace("#ID:", "").trim());
                } else if (line.startsWith("Name:")) {
                    name = line.replace("Name:", "").trim();
                } else if (line.startsWith("Price:")) {
                    price = Double.parseDouble(line.replace("Price:", "").trim());
                } else if (line.startsWith("Current Quantity:")) {
                    quantity = Integer.parseInt(line.replace("Current Quantity:", "").trim());
                } else if (line.startsWith("Image Path:")) {
                    imagePath = line.replace("Image Path:", "").trim();
                } else if (line.startsWith("---------------------------------------")) {
                    Item item = new Item(name, id, price, quantity, imagePath);
                    if (filePath.equals("./Computers.txt"))
                        Administrator.computers.add(item);
                    else if (filePath.equals("./Accessories.txt"))
                        Administrator.accessories.add(item);
                    else
                        Administrator.officeFurniture.add(item);
                }
            }
        } catch (IOException _) {
        }
    }

    /*To Edit a Meal From The Menu*/
//    public static void editMealInFile(String oldName, String newName, String newType, int newTotalQuantity,
//                                      float newPrice, String newImage, String newDescription, String filePath) {
//
//        ArrayList<String> meals = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] mealData = line.split("<>");
//                if (mealData[0].trim().equals(oldName)) {
//                    // Update the meal details
//                    line = newName + "<>" + newType + "<>" + newTotalQuantity + "<>" + newPrice + "<>" + newImage + "<>"
//                            + newDescription;
//                }
//                meals.add(line);
//            }
//        } catch (IOException _) {
//        }
//        // Write the updated meals back to the file
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//            for (String meal : meals) {
//                writer.write(meal);
//                writer.newLine();
//            }
//        } catch (IOException _) {
//        }
//        // Update the corresponding ArrayList
//        switch (filePath) {
//            case "Appetizers.txt" -> {
//                // Remove the old meal from AppetizerMeals
//                AppetizerMeals.removeIf(meal -> meal.getNameMeal().equals(oldName));
//                // Add the updated meal to AppetizerMeals
//                AppetizerMeals.add(new MealClass(newName, newTotalQuantity, newPrice, newImage, newDescription));
//            }
//            case "Main Meal.txt" -> {
//                // Remove the old meal from MainMealMeals
//                MainMealMeals.removeIf(meal -> meal.getNameMeal().equals(oldName));
//                // Add the updated meal to MainMealMeals
//                MainMealMeals.add(new MealClass(newName, newTotalQuantity, newPrice, newImage, newDescription));
//            }
//            case "Desserts.txt" -> {
//                // Remove the old meal from DessertMeals
//                DessertMeals.removeIf(meal -> meal.getNameMeal().equals(oldName));
//                // Add the updated meal to DessertMeals
//                DessertMeals.add(new MealClass(newName, newTotalQuantity, newPrice, newImage, newDescription));
//            }
//        }
//    }

    public static void removeItemFromFile(String nameToRemove, String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        ArrayList<String> updatedLines = new ArrayList<>();
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            ArrayList<String> currentItem = new ArrayList<>();
            boolean insideItem = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#ID:")) {
                    currentItem.clear();
                    insideItem = true;
                    currentItem.add(line);
                } else if (insideItem) {
                    currentItem.add(line);
                    if (line.startsWith("Name:")) {
                        String itemName = line.replace("Name:", "").trim();
                        if (itemName.equalsIgnoreCase(nameToRemove)) {
                            found = true;
                            insideItem = false; // Skip this item
                        }
                    }
                    if (line.startsWith("---------------------------------------")) {
                        if (!found) {
                            updatedLines.addAll(currentItem);
                        }
                        insideItem = false;
                        found = false; // Reset for next item
                    }
                } else {
                    updatedLines.add(line); // Lines outside item blocks (shouldn't happen but safe)
                }
            }
        } catch (IOException _) {

        }

        // Write The Data Again Into The File
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String l : updatedLines) {
                writer.write(l);
                writer.newLine();
            }
        } catch (IOException _) {

        }
    }


    /*To Write The Order From GUI To The File*/
//    public static void writeOrderToFile(int orderNum, String owner, String type, String phone, List<MealClass> meals,
//                                        float priceOrder, String payMethod, String note) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Orders.txt", true))) {
//            writer.write("Order #" + orderNum);
//            writer.newLine();
//            writer.write("Owner: " + owner);
//            writer.newLine();
//            writer.write("Type: " + type);
//            writer.newLine();
//            writer.write("Details: " + phone);
//            writer.newLine();
//
//            writer.write("Meals: ");
//            for (int i = 0; i < meals.size(); i++) {
//                MealClass meal = meals.get(i);
//                writer.write(meal.getNameMeal() + ", " + meal.getCurrQuantityMeal() + " pieces, " + meal.getPriceMeal() + "$");
//                if (i < meals.size() - 1) {
//                    writer.write(" + ");
//                }
//            }
//            writer.newLine();
//            writer.write("Total Price: " + priceOrder + "$");
//            writer.newLine();
//            writer.write("Payment Method: " + payMethod);
//            writer.newLine();
//            writer.write("Note: " + note);
//            writer.newLine();
//            writer.write("---------------------------------------");
//            writer.newLine();
//        } catch (IOException _) {
//        }
//    }


    /*To Read The Order From File To The GUI*/
//    public static void readOrdersFromFile() {
//        try (BufferedReader reader = new BufferedReader(new FileReader("Orders.txt"))) {
//            String line;
//            OrderClass currentOrder = null;
//
//            while ((line = reader.readLine()) != null) {
//                if (line.startsWith("Order #")) {
//                    if (currentOrder != null) {
//                        AdminClass.Orders.add(currentOrder);
//                    }
//                    currentOrder = new OrderClass();
//                    currentOrder.setNumberOrder(Integer.parseInt(line.split("#")[1].trim()));
//                } else if (line.startsWith("Owner:")) {
//                    assert currentOrder != null;
//                    currentOrder.setOwnerOrder(line.replace("Owner:", "").trim());
//                } else if (line.startsWith("Type:")) {
//                    assert currentOrder != null;
//                    currentOrder.setTypeOrder(line.replace("Type:", "").trim());
//                } else if (line.startsWith("Total Price:")) {
//                    assert currentOrder != null;
//                    currentOrder.setTotalPriceOrder(Float.parseFloat(line.replace("Total Price:", "").replace("$", "").trim()));
//                } else if (line.startsWith("Meals:")) {
//                    String mealsData = line.replace("Meals:", "").trim();
//                    String[] mealsArray = mealsData.split("\\s*\\+\\s*");
//                    ArrayList<MealClass> mealList = new ArrayList<>();
//                    for (String meal : mealsArray) {
//                        String[] mealParts = meal.split(", ");
//                        if (mealParts.length == 3) {
//                            String mealName = mealParts[0].trim();
//                            int quantity = Integer.parseInt(mealParts[1].replace(" pieces", "").trim());
//                            float price = Float.parseFloat(mealParts[2].replace("$", "").trim());
//                            mealList.add(new MealClass(mealName, price, quantity));
//                        }
//                    }
//                    assert currentOrder != null;
//                    currentOrder.Meals = mealList;
//
//                } else if (line.startsWith("Payment Method:")) {
//                    assert currentOrder != null;
//                    currentOrder.setPayMethod(line.replace("Payment Method:", "").trim());
//                } else if (line.startsWith("Note:")) {
//                    assert currentOrder != null;
//                    currentOrder.setNotes(line.replace("Note:", "").trim());
//                }
//            }
//            if (currentOrder != null) {
//                AdminClass.Orders.add(currentOrder);
//            }
//
//        } catch (IOException _) {
//        }
//    }
}
