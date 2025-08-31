#include <iostream>
#include <vector>
using namespace std;

class Drinks { // The class
    private:         // Access specifier
        int qty;     // Attribute (int variable)
        string name; // Attribute (string variable)
    public:
        // Setter
        void setQuantity(int q) {
            qty = q;
        }
        // Getter
        int getQuantity() {
            return qty;
        }
        // Setter
        void setName(string n) {
            name = n;
        }
        // Getter
        string getName() {
            return name;
        }
};

class Input {
    public:
        void checkInput(int &n, const vector<Drinks> &l, string opt) {
            while (true) { // Keep asking until the user enters a valid number
                if (!(cin >> n) && opt == "normal") {
                    cout << "Invalid input. Try again: ";
                    cin.clear();             // Reset input errors
                    cin.ignore(10000, '\n'); // Remove bad input
                }
                if (!l.empty() && (static_cast<unsigned int>(n) > l.size()) && opt == "list") {
                    cout << "input is greater than the size of the list, please input a number betweeen [1] and [" << l.size() << "]: ";
                    cin.clear();
                    cin.ignore(10000, '\n');
                    cin >> n;
                }
                break;
            }
    }
};

class List {
    public:
        void show(vector<Drinks> &n) {
            cout << "\n\n-=-=-=-=-=- all of the drinks -=-=-=-=-=- \n";

            if (n.empty()) {
                cout << "\nlist is empty\n";
                return;
            }

            for (size_t i = 0; i < n.size(); i++) {
                cout << "drink #" << i + 1 << endl;
                cout << "name: " << n[i].getName() << "\n";
                cout << "qty: " << n[i].getQuantity() << "\n";
                cout << "\n";
            }
    }
};

int main() {

    vector<Drinks> allDrinks; // a type of array that is resizeble, it can contain many or one data types

    // vector - resizable array
    // array - fixed array

    // string array[5] = {"jeje","cola"} - the number 5 indicates how much data it can handle, by now it only has 2 data
    // you can add more via -> array[2] = "heheh" output: "jeje","cola","heheh"
    // to change a value of an object inside an array simply indicate it's position and input an value
    // array[0]="heheheheh"; now instead of "jeje", it's "hehehehe"

    // data types
    int opt;
    int opt2;
    int opt3;
    int qty;     // for quantity input
    string name; // for name input

    // class and objects
    Input a;
    Drinks myDrink; // Create an object of myDrink
    List l;

    do {
        cout << "\n-=-=-=-=-=----- Drinks Menu -----=-=-=-=-=-\n";
        cout << "[1] Add a drink \n";
        cout << "[2] show the lists of drinks \n";
        cout << "[0] exit \n";
        cout << "say, what do you want to do with your drink: ";
        a.checkInput(opt, allDrinks, "normal"); // checks the user input

        switch (opt) {
            case 1:
                // set values
                cin.ignore();
                cout << "\nset the name of your drink [ex: coca-cola]: ";
                getline(cin, name);
                myDrink.setName(name); // sets the name of the drink

                cout << "\nset the quantity of your drinks [ex: 90]: ";
                a.checkInput(qty, allDrinks, "normal"); // validates the user input
                if (qty == 0) {
                    cout << "Quantity cannot be Zero!";
                }
                myDrink.setQuantity(qty);     // sets the quantity of a drink

                allDrinks.push_back(myDrink); // adds to the list
                break;
            case 2:
                // Access attributes
                //   string name1 = myDrink.getName();
                //   int qty1 = myDrink.getQuantity();
                do {
                    l.show(allDrinks);

                    if (!allDrinks.empty()) { //checks if the list is empty
                        cout << "[1] edit a drink\n";
                        cout << "[2] delete a drink \n";
                        cout << "[0] exit\n";
                        cout << "Action: ";
                        cin >> opt2;

                        switch (opt2) {
                            case 1:
                                l.show(allDrinks);

                                cout << "what drink would you like to edit: ";
                                a.checkInput(opt3, allDrinks, "list");

                                cout << "change name [" << allDrinks[opt3 - 1].getName() << "]: ";
                                cin >> name;

                                cout << "change qty [" << allDrinks[opt3 - 1].getQuantity() << "]: ";
                                cin >> qty;
                                if (qty == 0) {
                                    cout << "Quantity cannot be Zero!";
                                }

                                cout << "drink #" << opt3 << " " << allDrinks[opt3 - 1].getName() << " has been successfully edited!";

                                allDrinks[opt3 - 1].setName(name); //sets the new name of the chosen object
                                allDrinks[opt3 - 1].setQuantity(qty); //sets the new qty of the chosen object  
                                break;
                            case 2:
                                l.show(allDrinks);
                                cout << "what drink would you like to remove: ";
                                a.checkInput(opt3, allDrinks, "list");

                                cout << "drink #" << opt3 << " " << allDrinks[opt3 - 1].getName() << " has been successfully removed!";
                                allDrinks.erase(allDrinks.begin() + (opt3 - 1)); //removes an object based on index
                                break;
                        }
                    } else {
                        cout << "[0] exit\n";
                        cout << "Action: ";
                        cin >> opt2;
                    }

                } while (opt2 != 0);

                break;
            case 0:
                cout << "exit";
                break;
            default:
                cout << "\ninput is not on the options\n";
                break;
            // Print attribute values
            // default;
        }
    } while (opt != 0); // loop will end because opt == 0

    return 0;
}