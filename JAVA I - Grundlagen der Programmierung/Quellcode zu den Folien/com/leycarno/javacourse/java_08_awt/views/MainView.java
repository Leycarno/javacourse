package com.leycarno.javacourse.java_08_awt.views;

import com.leycarno.javacourse.java_08_awt.controllers.CarController;
import com.leycarno.javacourse.java_08_awt.controllers.PersonController;
import com.leycarno.javacourse.java_08_awt.controllers.RentalController;
import com.leycarno.javacourse.java_08_awt.controllers.RepositoryController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainView {

    public static Frame window = new Frame();
    public static Panel viewPort = new Panel();

    // ************************************************************
    // create other views and controllers in a view is "quick and dirty"
    // better would be a proper dispatcher -> JAVA 2
    // if they would not be "static", this "hack" could end in an endless-loop...
    // ************************************************************

    private static PersonView personView = new PersonView();
    private static CarView carView = new CarView();

    private static RepositoryController repositoryController = new RepositoryController();
    private static PersonController personController = new PersonController();
    private static CarController carController = new CarController();
    private static RentalController rentalController = new RentalController();


    public MainView() {

        window.setTitle("Autovermietung - Hauptmenü");   // set title of the window
        window.setSize(800, 600);                        // set the size of the window
        window.setResizable(false);                      // do not change the size of the window

        // create the menuBar with menuItems
        window.setMenuBar(buildMenubar());
        // and whats left is the viewport
        window.add(viewPort);

        // add some description for the startView
        Label label = new Label();
        label.setText("Willkommen bei der Kieler Förde Autovermietung - "
                + "Bitte wählen Sie die nächste Aktion aus dem Menü aus");
        label.setAlignment(Label.CENTER);
        viewPort.add(label);

        // see method-description below (we need this to quit the app)
        window.addWindowListener(new TestWindowListener());

        // ok - show me the window!
        window.setVisible(true);
    }

    private MenuBar buildMenubar() {
        MenuBar menuebar = new MenuBar();

        // create the topics
        Menu mainMenu = new Menu("Daten");
        Menu personMenu = new Menu("Kunden");
        Menu carMenu = new Menu("Fahrzeuge");
        Menu rentalMenu = new Menu("Vermietungen");

        menuebar.add(mainMenu);
        menuebar.add(personMenu);
        menuebar.add(carMenu);
        menuebar.add(rentalMenu);

        // ============================================================
        // now we create some menuItems 3 times (nearly) the same,
        // but every version smaller and better to read!
        // ============================================================
        // VERSION 1
        // 1. create the elements
        // 2. set (onClick-action) on elements
        // 3. add element to topic
        MenuItem loadMenuItem = new MenuItem("Daten laden");
        MenuItem storeMenuItem = new MenuItem("Daten speichern");
        loadMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repositoryController.loadData();
            }
        });
        storeMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repositoryController.storeData();
            }
        });
        mainMenu.add(loadMenuItem);
        mainMenu.add(storeMenuItem);

        // ============================================================
        // VERSION 1 - using JAVA 8-Lambda (more about lambda >>> JAVA II-Course)
        MenuItem showPeopleMenuItem = new MenuItem("Alle Kunden auflisten");
        MenuItem addPeopleMenuItem = new MenuItem("Neuen Kunden aufnehmen");
        showPeopleMenuItem.addActionListener(e -> personController.listAllPersons());
        addPeopleMenuItem.addActionListener(e -> personView.showPersonForm());
        personMenu.add(showPeopleMenuItem);
        personMenu.add(addPeopleMenuItem);

        // ============================================================
        // VERSION 3 - using JAVA 8-Lambda and static Initialisation
        carMenu.add(new MenuItem("Alle Fahrzeuge auflisten") {{
            addActionListener(e -> carController.listAllCars());
        }});
        carMenu.add(new MenuItem("Neues Fahrzeug aufnehmen") {{
            addActionListener(e -> carView.showCarForm());
        }});

        rentalMenu.add(new MenuItem("Alle Vermietungen auflisten") {{
            addActionListener(e -> rentalController.showRentals());
        }});
        rentalMenu.add(new MenuItem("Neue Vermietung") {{
            addActionListener(e -> rentalController.showCarRental());
        }});
        rentalMenu.add(new MenuItem("Vermietetes Fahrzeug zurücknehmen") {{
            addActionListener(e -> rentalController.showCarWithdraw());
        }});

        return menuebar;
    }

    /**
     * a simple and compact Error-Dialog
     */
    public static void showErrorDialog(String errorMessage) {
        Dialog dialog = new Dialog(MainView.window, "Fehlermeldung") {{
            // set size
            setSize(600, 100); // has to be so long, because AWT has no native label-text-wrap :(   => see "Java Swing"
            // and make sure we can always see it
            setAlwaysOnTop(true);
            // set the position/location - relative to the current position of the main-window
            setLocation(MainView.window.getLocation().x + 100, MainView.window.getLocation().y + 100);
            // add the errorMessage as red label
            add(new Panel(new GridLayout(2, 1)) {{
                add(new Label(errorMessage) {{ setForeground(Color.red); setAlignment(CENTER);}});
            }});
            // close the window proper by the X upper right...
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent){
                    dispose();
                }
            });
        }};
        // ! SHOW the Dialog
        dialog.setVisible(true);
    }

    // ****************************************************************************************************

    /**
     * inner classes and inheritance are topics of JAVA 2
     * "Adapters" is another "Design-Pattern" (for more info...google)
     *
     * we need this just to kill the app by close the window
     */
    private class TestWindowListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            e.getWindow().dispose();    // kill the window
            System.exit(0);      // kill the app
        }
    }
}
