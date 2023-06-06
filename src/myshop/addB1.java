package myshop;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



/**
 *
 * @author odipojames12
 */

public class addB1 extends JFrame  implements ActionListener  {

Statement statement;
JButton addProdButton;
JButton updateProductButon;
      
JTextField productName;
JTextField productId;
JTextField productUnit;
JTextField productQuantity;
JTextField productPrice;
JButton displayButton1;
JTable table1;
JButton clearButton1;
JTextField searchT1;
JButton searchB1;
JComboBox c1,c2,roleC;
JTable catTable;
JTextField sumTexFld;
JButton addB1;
JTextField balanceTexFld;
JTextField paidTexFld;
JTextField q1;
JButton sellB1;
JTable allProductsTable;
JButton loadAllB;
JTextField  srchFld;
JButton searchAllB;
JButton editProductB;
JTextField editName;
JTextField editUnit;
JTextField editQuantity;
JTextField editPrice;
JButton saveB;
JButton deleteB;
JTable restockTable,usersTable ;
JButton restockB1;
JButton addB2,createUserB,editUserB;
JTextField sumTexFld1,q2,p1,userName,editUserName,editUserRole,editUserPassword;
JPasswordField passwordP;
JFrame  jm = new JFrame();
public static boolean isAuthenticated = false;
public static String logUser = "";
public static String role = "";

   
     
    
         
    addB1(){
       JDialog.setDefaultLookAndFeelDecorated(true);
       
        JPanel allProductViewPanel = new JPanel();
        JPanel pn2 = new JPanel();
        JPanel restockPanel = new JPanel();
        JPanel addProductsPanel = new JPanel(new BorderLayout());
        JTabbedPane tabs = new JTabbedPane();
        
        allProductViewPanel.setSize(1000, 500);
        //pn2.setSize(1000, 500);
        restockPanel.setSize(1000, 500);
        tabs.setBounds(100, 100, 300, 300);
        tabs.add("Add New  Products",addProductsPanel);
        
       
        //layouts
        GridLayout grid = new GridLayout(3,3,2,5);
        GridLayout grid1 = new GridLayout(2,2,2,5);
        
                
        //add products panel
        //display products table panel
        Font buttonFont = new Font("Tahoma",Font.BOLD,12);
        JScrollPane table1Scroller =new JScrollPane();
        table1 = new JTable();
        table1.setBounds(268, 52, 600, 200);
        
        searchT1 = new JTextField("search by name or id",30);
        searchT1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchT1.setText("");
            }
        });

        searchB1 = new JButton("search");
        searchB1.addActionListener((this));
        searchT1.setColumns(15);
        table1Scroller.setViewportView(table1);
        JPanel allProductsPanel = new JPanel();
        JPanel allProductsPane2 = new JPanel();
        allProductsPanel.add(table1Scroller);
        displayButton1 = new JButton("Show Products");
        displayButton1.setFont(buttonFont);
        displayButton1.addActionListener((this));
        clearButton1 = new JButton("Clear");
        clearButton1.addActionListener((this));
        clearButton1.setFont(buttonFont);
        allProductsPane2.add(displayButton1);
        allProductsPane2.add(clearButton1);
        allProductsPane2.add(searchT1);
        allProductsPane2.add(searchB1);
        //allProductsPane2.setLayout(grid1);
        //allProductsPanel.setLayout(grid1);
        allProductsPanel.setBorder(new EmptyBorder(5, 50, 10, 50));
        allProductsPanel.setBackground(Color.lightGray);
        //allProductsPanel.setBorder(new EmptyBorder(30, 50, 50, 50));
        addProductsPanel.add(pn2,BorderLayout.NORTH);
        addProductsPanel.add(allProductsPanel,BorderLayout.CENTER);
        addProductsPanel.add(allProductsPane2,BorderLayout.SOUTH);
        
        pn2.setSize(200, 200);
        pn2.setLayout(grid);
        pn2.setBorder(new EmptyBorder(30, 50, 50, 50));
        JLabel nameLabel = new JLabel("Name product");
        productName = new JTextField();
        //JLabel idLabel = new JLabel("Product Id");
        productId = new JTextField(10);
        productId.addKeyListener(new JTextFieldKeyListener(productId));
        JLabel unitLabel = new JLabel("Unit");
        productUnit = new JTextField("kgs");
        JLabel quantityLabel = new JLabel("Number of units");
        productQuantity = new JTextField(10);
        productQuantity.addKeyListener(new JTextFieldKeyListener(productQuantity));
        JLabel priceLabel = new JLabel("Price");
        productPrice = new JTextField(10);
        productPrice.addKeyListener(new JFloatListener(productPrice));
        JLabel dammy = new JLabel("");
        addProdButton = new JButton("add product");
        addProdButton.addActionListener((this));
        pn2.add(nameLabel);pn2.add(productName);pn2.add(unitLabel);pn2.add(productUnit); pn2.add(quantityLabel);pn2.add(productQuantity);
        pn2.add(priceLabel); pn2.add(productPrice);pn2.add(dammy); pn2.add(addProdButton);
        
        
        
        
        //sell products window
        GridLayout grid2 = new GridLayout(1,7,5,2);
        JPanel sellProductPanel = new JPanel();
        JPanel sellProductPanel1 = new JPanel();
        sellProductPanel.setSize(1000, 500);
        sellProductPanel1.setBorder(new EmptyBorder(20, 50, 50, 50));
        tabs.add("Sell Product",sellProductPanel);
        sellProductPanel.setLayout(new BorderLayout());
        sellProductPanel.add(sellProductPanel1,BorderLayout.NORTH);
        c1 = new JComboBox();
        c1.addItem("Select Product");
        c1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                filComb();
            }
        });
        JLabel lbQ = new JLabel("Quantity");
        JLabel dumn = new JLabel("");
        addB1 = new JButton("add");
        addB1.addActionListener((this));
        q1 = new JTextField(5);
        q1.addKeyListener(new JTextFieldKeyListener(q1));
        sellProductPanel1.add(c1);sellProductPanel1.add(lbQ);sellProductPanel1.add(q1);
        sellProductPanel1.add(addB1);sellProductPanel1.add(dumn);sellProductPanel1.add(dumn);
        sellProductPanel1.add(dumn);
       
        
        JPanel sellProductPanel2 = new JPanel();
        sellProductPanel2.setLayout(new BorderLayout());
        sellProductPanel.add(sellProductPanel2,BorderLayout.CENTER);
        DefaultTableModel catTablemodel = new DefaultTableModel();
        catTablemodel.addColumn("ID");
        catTablemodel.addColumn("Name");
        catTablemodel.addColumn("Unit");
        catTablemodel.addColumn("Quantity");
        catTablemodel.addColumn("Total Ksh");
        catTable = new JTable(catTablemodel);
        catTable.setBounds(40, 50, 300, 200);
        //dissable cell from edditing
        for (int c = 0; c < catTable.getColumnCount(); c++)
        {
            Class<?> col_class = catTable.getColumnClass(c);
            catTable.setDefaultEditor(col_class, null);        // remove editor
        }
	// Adding Jtable to JScrollPane
	JScrollPane sp = new JScrollPane(catTable);
        JPanel buttP= new JPanel();
        buttP.setLayout(new GridLayout(12,1,5,2));
        sellB1  = new JButton("sell");
        sellB1.addActionListener((this));
        JButton rmB  = new JButton("remove");
        rmB.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
         if(catTable.getSelectedRow() != -1) {
               // remove selected row from the model
               catTablemodel.removeRow(catTable.getSelectedRow());
               catSum();
               sumTexFld.setText(Integer.toString(catSum()));
               System.out.println(isAuthenticated);
                System.out.println(role);
            }
        }
        
        });
        JButton rmB1  = new JButton("remove all");
        rmB1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        DefaultTableModel dtm = (DefaultTableModel) catTable.getModel();
        dtm.setRowCount(0);
        catSum();
        sumTexFld.setText(Integer.toString(catSum()));
        }
        
        });
        JLabel sumLabel = new JLabel("Total Sum:");
        sumTexFld = new JTextField(10);
        sumTexFld.setEditable(false);
        sumTexFld.addKeyListener(new JTextFieldKeyListener(sumTexFld));
        JLabel balanceLabel = new JLabel("Balance ");
        balanceTexFld = new JTextField(10);
        balanceTexFld.setEditable(false);
        JLabel paidLabel = new JLabel("Amount Paid ");
        paidTexFld = new JTextField(10);
        paidTexFld.addKeyListener(new JTextFieldKeyListener(paidTexFld));
        balanceTexFld.addMouseListener(new MouseAdapter(){
          @Override
            public void mouseEntered(MouseEvent e) {
                if(!paidTexFld.getText().equals("") && catSum()< Integer.parseInt(paidTexFld.getText()) ){
                    balanceTexFld.setText(Integer.toString(Integer.parseInt(paidTexFld.getText())-catSum()));
                }
                else{
                  balanceTexFld.setText("0");
                }
            }
        });
     
        buttP.add(rmB);buttP.add(rmB1);buttP.add(sellB1);
        buttP.add(sumLabel);buttP.add(sumTexFld);
        buttP.add(paidLabel);buttP.add(paidTexFld);
        buttP.add(balanceLabel);buttP.add(balanceTexFld);
        sellProductPanel2.add(sp,BorderLayout.CENTER);
        sellProductPanel2.add(buttP,BorderLayout.EAST);
        
      
        //view all products window
         if(isAuthenticated && role.equalsIgnoreCase("admin")){
          tabs.add("View All Products",allProductViewPanel);   
    }
     
         allProductViewPanel.setLayout(new BorderLayout());
         JPanel allProductViewPanel1  = new JPanel();
         JPanel allProductViewPanel2  = new JPanel();
         JPanel allProductViewPanel3  = new JPanel();
         JPanel centralPanel  = new JPanel();
         centralPanel.setLayout(new GridLayout(1,2));
   
        DefaultTableModel allProductsTableModel = new DefaultTableModel();
        allProductsTableModel.addColumn("ID");
        allProductsTableModel.addColumn("Name");
        allProductsTableModel.addColumn("Unit");
        allProductsTableModel.addColumn("Quantity");
        allProductsTableModel.addColumn("Price");
        allProductsTable = new JTable(allProductsTableModel);
        allProductsTable.setBounds(40, 50, 300, 200);
        //dissable cell from edditing
        for (int c = 0; c < allProductsTable.getColumnCount(); c++)
        {
            Class<?> col_class = allProductsTable.getColumnClass(c);
            allProductsTable.setDefaultEditor(col_class, null);        // remove editor
        }
	// Adding Jtable to JScrollPane
	JScrollPane sp1 = new JScrollPane(allProductsTable);
        allProductViewPanel1.add(sp1);
        allProductViewPanel.add(centralPanel,BorderLayout.CENTER);
        JPanel leftJPanel = new JPanel();
        leftJPanel.setLayout(new BorderLayout());
        JPanel tableButtonsJPanel = new JPanel();
        leftJPanel.add(allProductViewPanel1,BorderLayout.NORTH);
        
        loadAllB = new JButton("show all");
        loadAllB.addActionListener((this));
         srchFld = new JTextField(10);
         srchFld.setText("name or id");
         srchFld.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                srchFld.setText("");
            }
        });
        searchAllB = new JButton("search");
        searchAllB.addActionListener((this));
        tableButtonsJPanel.add(loadAllB);tableButtonsJPanel.add(srchFld);
        tableButtonsJPanel.add(searchAllB);
        leftJPanel.add(tableButtonsJPanel,BorderLayout.CENTER);
        
        
        centralPanel.add( leftJPanel);
       
        editProductB = new JButton("Edit");
        editProductB.addActionListener((this));
        saveB = new JButton("Save");
        saveB.addActionListener((this));
        deleteB = new JButton("Delete");
        deleteB.addActionListener((this));
        allProductViewPanel2.add(editProductB);  allProductViewPanel2.add(deleteB);
        allProductViewPanel.add(allProductViewPanel2,BorderLayout.NORTH);
        
        JLabel editNamel = new JLabel("name");
        editNamel.setPreferredSize(new Dimension(70,100));
        JLabel editUnitl = new JLabel("unit");
        editUnitl.setPreferredSize(new Dimension(120,100));
        JLabel editQuantityl = new JLabel("quantity");
        editQuantityl.setPreferredSize(new Dimension(120,100));
        JLabel editPricel = new JLabel("price per unit");
        editPricel.setPreferredSize(new Dimension(120,100));
        
        editName = new JTextField(5);
        //editName.setPreferredSize(new Dimension(10,2));
        editUnit = new JTextField(10);
        editQuantity = new JTextField(10);
        editQuantity.addKeyListener(new JTextFieldKeyListener(editQuantity));
        editPrice = new JTextField(10);
        editPrice.addKeyListener(new JTextFieldKeyListener(editPrice));
        allProductViewPanel3.setLayout(new GridLayout(0,2,0,0));
        allProductViewPanel3.setBorder( new EmptyBorder(20, 20, 20, 20) );
        allProductViewPanel3.add(editNamel);allProductViewPanel3.add(editName);
        allProductViewPanel3.add(editUnitl);allProductViewPanel3.add(editUnit);
        allProductViewPanel3.add(editQuantityl);allProductViewPanel3.add(editQuantity);
        allProductViewPanel3.add(editPricel);allProductViewPanel3.add(editPrice);
        allProductViewPanel3.add(saveB);
        Border border = new CompoundBorder(
            new TitledBorder("Edit"), 
            new EmptyBorder(80, 50, 80, 50));
        allProductViewPanel3.setBorder(border);
        
        centralPanel.add(allProductViewPanel3);
        
        
        //restock winow
        GridLayout grid3 = new GridLayout(1,7,5,2);
        JPanel restockPanel1 = new JPanel();
        restockPanel.setSize(1000, 500);
        restockPanel1.setBorder(new EmptyBorder(20, 50, 50, 50));
        //tabs.add("restock Product",sellProductPanel);
        if(isAuthenticated && role.equalsIgnoreCase("admin")){
            tabs.add("Restock Products ",restockPanel);
        }
        restockPanel.setLayout(new BorderLayout());
        restockPanel.add(restockPanel1,BorderLayout.NORTH);
        c2 = new JComboBox();
        c2.addItem("Select Product");
        c2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                filComb2();
            }
        });
        addB2 = new JButton("add");
        addB2.addActionListener((this));
        JLabel q2label = new JLabel("quantity");
        q2 = new JTextField(10);
        q2.addKeyListener(new JTextFieldKeyListener(q2));
        JLabel pricel1 = new JLabel("price per unit");
        p1 = new JTextField(10);
        p1.addKeyListener(new JTextFieldKeyListener(p1));
        restockPanel1.add(c2);restockPanel1.add(q2label);restockPanel1.add(q2);
        restockPanel1.add(pricel1);restockPanel1.add(p1);
        restockPanel1.add(addB2);restockPanel1.add(dumn);restockPanel1.add(dumn);
        restockPanel1.add(dumn);
       
        
        JPanel restockPanel2 = new JPanel();
        restockPanel2.setLayout(new BorderLayout());
        restockPanel.add(restockPanel2,BorderLayout.CENTER);
        DefaultTableModel restockTablemodel = new DefaultTableModel();
        restockTablemodel.addColumn("ID");
        restockTablemodel.addColumn("Name");
        restockTablemodel.addColumn("Unit");
        restockTablemodel.addColumn("Quantity");
        restockTablemodel.addColumn("Price per uinit Ksh");
        restockTable = new JTable(restockTablemodel);
        restockTable.setBounds(40, 50, 300, 200);
        //dissable cell from edditing
        for (int c = 0; c < restockTable .getColumnCount(); c++)
        {
            Class<?> col_class = restockTable.getColumnClass(c);
            restockTable.setDefaultEditor(col_class, null);        // remove editor
        }
	// Adding Jtable to JScrollPane
	JScrollPane sp3 = new JScrollPane(restockTable );
        JPanel restockButtons= new JPanel();
        restockButtons.setLayout(new GridLayout(12,1,5,2));
        restockB1  = new JButton("restock");
        restockB1.addActionListener((this));
        JButton rmB3  = new JButton("remove");
        rmB3.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
         if(restockTable.getSelectedRow() != -1) {
               // remove selected row from the model
               restockTablemodel.removeRow(restockTable.getSelectedRow());
               restockCatSum();
               sumTexFld1.setText(Integer.toString(restockCatSum()));
            }
        }
        
        });
        JButton rmB4  = new JButton("remove  all");
        rmB4.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        DefaultTableModel dtm = (DefaultTableModel) restockTable.getModel();
        dtm.setRowCount(0);
        restockCatSum();
        sumTexFld1.setText(Integer.toString( restockCatSum()));
        }
        
        });
        JLabel sumLabel1 = new JLabel("Total Sum:");
        sumTexFld1 = new JTextField(10);
        sumTexFld1.setEditable(false);
        sumTexFld1.addKeyListener(new JTextFieldKeyListener(sumTexFld1));
        restockButtons.add(rmB3);restockButtons.add(rmB4);restockButtons.add(restockB1);
        restockButtons.add(sumLabel1);restockButtons.add(sumTexFld1);
        restockPanel2.add(sp3,BorderLayout.CENTER);
        restockPanel2.add(restockButtons,BorderLayout.EAST);
        
        
        //users
        JPanel userPanel = new JPanel();
        userPanel.setLayout(null);
        Border blackline1 = BorderFactory.createTitledBorder("user manger");
        userPanel.setBorder(blackline1);
        //add user
        JLabel userLabel = new JLabel("username");
        userLabel.setBounds(200, 15, 200, 20);
        userPanel.add(userLabel);
        userName = new JTextField();
        userName.setBounds(200, 40, 200, 20);
        userPanel.add(userName);
        
        JLabel passwordLabel = new JLabel("password");
        passwordLabel.setBounds(500, 15, 200, 20);
        userPanel.add(passwordLabel);
        passwordP = new JPasswordField();
        passwordP.setBounds(500, 40, 200, 20);
        userPanel.add(passwordP);
        
        String[] rl = {"normal","admin"};
        JLabel roleLabel =new JLabel("user role");
        roleLabel.setBounds(200, 60, 200, 20);
        userPanel.add(roleLabel);
        roleC = new JComboBox(rl);
        roleC.setBounds(200, 80, 200, 20);
        userPanel.add(roleC);
        createUserB = new JButton("create new user");
        createUserB.setBounds(500, 80, 200, 20);
        createUserB.addActionListener((this));
        userPanel.add(createUserB);
        
        //users table
       
        DefaultTableModel usersTablemodel = new DefaultTableModel();
        usersTablemodel.addColumn("ID");
        usersTablemodel.addColumn("USERNAME");
        usersTablemodel.addColumn("ROLE");
        usersTable = new JTable(usersTablemodel);
        //dissable cell from edditing
        for (int c = 0; c < usersTable .getColumnCount(); c++)
        {
            Class<?> col_class = usersTable.getColumnClass(c);
            usersTable.setDefaultEditor(col_class, null);        // remove editor
        }
        JScrollPane sp4 = new JScrollPane(usersTable);
        sp4.setBounds(30, 150, 300, 300);
        userPanel.add(sp4);
        JButton editUser = new JButton("Edit");
        
        
        
        editUser.setBounds(350, 150, 100, 20);
        userPanel.add(editUser);
        JButton deleteUser = new JButton("Delete");
        deleteUser.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
         if(usersTable.getSelectedRow()<0){
        JOptionPane.showMessageDialog(null, "select user","Error!",JOptionPane.ERROR_MESSAGE);
        }
        else{
        try{
            Connection conn =  getConnection();
            Statement st = conn.createStatement();
            String sql = "DELETE FROM users WHERE id = '"+usersTable.getValueAt(usersTable.getSelectedRow(), 0)+"' ";
            String name = usersTable.getValueAt(usersTable.getSelectedRow(), 1).toString();
            //confirm
            JDialog.setDefaultLookAndFeelDecorated(true);
            int response = JOptionPane.showConfirmDialog(null, "Do you want to delete "+name+" ?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION){
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " "+name+" deleted ");
            usersTableShow();
        }
                
            
        } 
          
        catch(SQLException ex){
          System.out.println(ex.getMessage());
          }
            
            
        }
        
        }
        
        
        });
        
        
        deleteUser.setBounds(350, 180, 100, 20);
        userPanel.add(deleteUser);
        
        JButton viewUsers = new JButton("View Users");
        viewUsers.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        usersTableShow();
        }
        
        });
        viewUsers.setBounds(350, 220, 100, 20);
        userPanel.add(viewUsers);

        
        JPanel editF = new JPanel();
        Border blackline2 = BorderFactory.createTitledBorder("edit user");
        editF.setBorder(blackline2);
        editF.setBounds(500, 150, 400, 300);
        editF.setLayout(null);
        
        JLabel editUserLabel = new JLabel("Username");
        editUserLabel.setBounds(60, 45, 100, 20);
        editF.add(editUserLabel);
        editUserName = new JTextField();
        editUserName.setBounds(180, 50, 100, 20);
        editF.add(editUserName);
        
        JLabel editUserRoleLabel = new JLabel("Role");
        editUserRoleLabel .setBounds(60, 75, 100, 20);
        editF.add(editUserRoleLabel );
        editUserRole = new JTextField();
        editUserRole.setBounds(180, 80, 100, 20);
        editF.add(editUserRole);
        
        JLabel editUserPasswordLabel = new JLabel("Password");
        editUserPasswordLabel.setBounds(60, 105, 100, 20);
        editF.add(editUserPasswordLabel);
        editUserPassword = new JTextField();
        editUserPassword.setBounds(180, 110, 100, 20);
        editF.add(editUserPassword);
        
        editUserB=new JButton("save");
        editUserB.setBounds(180, 150, 100, 20);
        editUserB.addActionListener((this));
        
        editUser.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        
         //check product not picked
         if(usersTable.getSelectedRow()<0){
         JOptionPane.showMessageDialog(null, "you must select user from table","Error!", JOptionPane.ERROR_MESSAGE);
         }
         else{
             try {
                 //read selected data
                 editUserName.setText(usersTable.getValueAt(usersTable.getSelectedRow(), 1).toString());
                 editUserRole.setText(usersTable.getValueAt(usersTable.getSelectedRow(), 2).toString());
                 
                 
                 
                 Connection conn =  getConnection();
                 Statement st = conn.createStatement();
                 String sql = "SELECT * FROM users WHERE id = '"+usersTable.getValueAt(usersTable.getSelectedRow(), 0).toString()+ "'";
                 ResultSet rs =  st.executeQuery(sql);
                 if(rs.next()){
                 editUserPassword.setText(rs.getString(3));
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(addB1.class.getName()).log(Level.SEVERE, null, ex);
             }
        
         
         
         }
    
        }     });
        editF.add(editUserB);
        userPanel.add(editF);
   
        
        if(isAuthenticated && role.equalsIgnoreCase("admin")){
            tabs.add("User Manager ",userPanel);
        }
        
         
         
         
        
        
        
        
        
        
        
        
        
        
        
        
     
          
        jm.add(tabs);
        jm.setTitle("SHOP MANAGER");
        jm.setSize(1000, 600);
        jm.setLocationRelativeTo(null);
        //jm.pack();
        jm.setVisible(true);
        jm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jm.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent we)
    { 
        String ObjButtons[] = {"LogOut","Exit"};
        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to logout or exit?","Shop Manager",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION)
        {
         jm.dispose();
         new loginPage();
          
        }
         if(PromptResult==JOptionPane.NO_OPTION){
         System.exit(0);
         }
    }
});
    
    }
   
    //connection tofdatabase
    
    public static Connection getConnection(){
     try{
          Class.forName("com.mysql.cj.jdbc.Driver");
     }
     catch(ClassNotFoundException e){
         System.out.println("DB driver not found!");
         System.out.println(e.getMessage());
         
     }
     Connection conn = null;
     
     try{
     conn= DriverManager.getConnection("jdbc:mysql://localhost/products","root","");
     
     }
     catch(SQLException e){
         System.out.println(e.getMessage());
         System.out.println("DB not connected! user or password incorrect");
     }
    
    return conn;
    }
    
    
    //method to get sum on catTable
      public int catSum(){
        int sum = 0;
        int rowCount =  catTable.getRowCount();
        for(int i=0;i<rowCount;i++){
         sum = sum+ Integer.parseInt(catTable.getValueAt(i, 4).toString());
        }
        return sum;
      }
      
      //method to get sum on catTable
      public int restockCatSum(){
        int sum = 0;
        int rowCount =  restockTable.getRowCount();
        for(int i=0;i<rowCount;i++){
         sum = sum+ Integer.parseInt(restockTable.getValueAt(i, 4).toString());
        }
        return sum;
      }
      
    //method to dispaly all data 
    
    public void displayAllProductstable(){
    
     table1.setModel(new DefaultTableModel());
          try {
              Connection conn=getConnection();
              Statement st = conn.createStatement();
              String query = "SELECT * from products ORDER BY date DESC ";
              ResultSet rs =  st.executeQuery(query);
              ResultSetMetaData rsmd = rs.getMetaData();
              //table model
              DefaultTableModel model = (DefaultTableModel) table1.getModel();
              
              
              //get column count
              int cols = rsmd.getColumnCount();
              
              String[] colName =new String[cols];
              //get col names from db
              for(int i=0;i<cols;i++)
                  colName[i]= rsmd.getColumnName(i+1);
              model.setColumnIdentifiers(colName);
              
              //reading rows from db
              String name,id,unit,quantity,price,date;
              while(rs.next()){
              name=rs.getString(1);
              id=rs.getString(2);
              unit = rs.getString(3);
              quantity =rs.getString(4);
              price = rs.getString(5);
              date = rs.getString(6);
              
              String[] row = {name,id,unit,quantity,price,date};
              model.addRow(row);
              
              }
              st.close();
              conn.close();
              
             
           System.out.println("DB connected!");
          } 
          catch (SQLException ex) {
               System.out.println(ex.getMessage());
               System.out.println("mySQL error");
              Logger.getLogger(addB1.class.getName()).log(Level.SEVERE, null, ex);
          }
     
    }
    
    
    //search by id or name table
    
    public void displaySearchedProductstable(){
                table1.setModel(new DefaultTableModel());
                if(searchT1.getText().equals("") || searchT1.getText().equalsIgnoreCase("search by name or id")){
                JOptionPane.showMessageDialog(this, "you must enter name or id of product!","Error!", JOptionPane.ERROR_MESSAGE);
                }
                
     
                else{
                
                try {
              
              Connection conn = getConnection();
              Statement st = conn.createStatement();
              String query = "";
              String searchItem = searchT1.getText();
              if(searchItem.matches("\\d+")){//check if its an id input
              query = "SELECT * FROM products WHERE id = '"+searchItem + "'";
              }
              if(!searchItem.matches("\\d+")){
              query = "SELECT * FROM products WHERE name LIKE '%' '"+ searchItem +"' '%'";
              }
              
              ResultSet rs =  st.executeQuery(query);
              if(rs.isBeforeFirst()){
              
              ResultSetMetaData rsmd = rs.getMetaData();
              //table model 
              DefaultTableModel model = (DefaultTableModel) table1.getModel();
              
              
              //get column count
              int cols = rsmd.getColumnCount();
              
              String[] colName =new String[cols];
              //get col names from db
              for(int i=0;i<cols;i++)
                  colName[i]= rsmd.getColumnName(i+1);
              model.setColumnIdentifiers(colName);
              
              //reading rows from db
              String name,id,unit,quantity,price,date;
              while(rs.next()){
              name=rs.getString(1);
              id=rs.getString(2);
              unit = rs.getString(3);
              quantity =rs.getString(4);
              price = rs.getString(5);
              date = rs.getString(6);
              
              String[] row = {name,id,unit,quantity,price,date};
              model.addRow(row);
              
              }
              st.close();
              conn.close();
              }
              else{
              JOptionPane.showMessageDialog(this, "search item not found!");
              }
              
             
              System.out.println("DB connected!");
          } 
          catch (SQLException ex) {
               System.out.println(ex.getMessage());
               System.out.println("mySQL error");
              Logger.getLogger(addB1.class.getName()).log(Level.SEVERE, null, ex);
          }
                    
                }
     
    }
    
    
    //method to search product already exists
    public boolean searchByName(String sname){
      boolean check = false;
      
      try{
        Connection conn = getConnection(); 
        Statement st = conn.createStatement();
        String sql = "SELECT name FROM products WHERE name = '"+sname + "'";
        ResultSet result =  st.executeQuery(sql);
        if(result.isBeforeFirst()){
        check = true;
        }
        st.close();
        conn.close();
      }
      catch(Exception e){
          System.out.print(e.getMessage());
      }
     
      return check;
      
         }
    
    //select products 
        public void  filComb(){
     
      
      try{
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        String sql = "SELECT name FROM products";
        ResultSet rs =  st.executeQuery(sql);
        
        while(rs.next()){
            c1.addItem(rs.getString("name"));
        }
        
        st.close();
        conn.close();
       
      }
      catch(Exception e){
          System.out.print(e.getMessage());
      }
     
    }
        
        
   //select products 
        public void  filComb2(){
     
      
      try{
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        String sql = "SELECT name FROM products";
        ResultSet rs =  st.executeQuery(sql);
        
        while(rs.next()){
            c2.addItem(rs.getString("name"));
        }
        
        st.close();
        conn.close();
       
      }
      catch(Exception e){
          System.out.print(e.getMessage());
      }
     
    }     
        
        //adding product to cat table
    public void addToCat(){
        
       if(c1.getSelectedItem().toString().equalsIgnoreCase("Select Product")){
          JOptionPane.showMessageDialog(null, "select product","Error!", JOptionPane.ERROR_MESSAGE);
          c1.requestFocus();
          
       }
       else if(q1.getText().equals("")){
          JOptionPane.showMessageDialog(null, "enter quantity","Error!", JOptionPane.ERROR_MESSAGE);
          q1.requestFocusInWindow();
         
       }
          
       else{
        try{
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        String select = c1.getSelectedItem().toString();
        String sql = "SELECT * FROM products WHERE name = '"+select+ "'";
        ResultSet rs =  st.executeQuery(sql);
        DefaultTableModel model = (DefaultTableModel) catTable.getModel();
        String name,id,unit,quantity,total;
        
         
        
        while(rs.next()){
             if(Integer.parseInt(rs.getString(4))>= Integer.parseInt(q1.getText())){
               id=rs.getString(2);
               name=rs.getString(1);
               unit = rs.getString(3);
               quantity =  q1.getText();
               total = Integer.toString(Integer.parseInt(rs.getString(5))*Integer.parseInt(q1.getText()));
          
              String[] row = {id,name,unit,quantity,total};
              model.addRow(row);
              
             }
             
           if(Integer.parseInt(rs.getString(4))< Integer.parseInt(q1.getText())){
       
            JOptionPane.showMessageDialog(null,"few of this product remaining in stok \n please check quantity remaining" );
        }
             
            
            
        }
         st.close();
         conn.close();
        
         sumTexFld.setText(Integer.toString(catSum()));
       
      }
      catch(Exception e){
          System.out.print(e.getMessage());
      }
       
       }
        
    } 
    
    
    
    //adding product to cat table
    public void addToRestockTable(){
        
       if(c2.getSelectedItem().toString().equalsIgnoreCase("Select Product")){
          JOptionPane.showMessageDialog(null, "select product","Error!", JOptionPane.ERROR_MESSAGE);
          c2.requestFocus();
          
       }
       else if(q2.getText().equals("")){
          JOptionPane.showMessageDialog(null, "enter quantity","Error!", JOptionPane.ERROR_MESSAGE);
          q2.requestFocusInWindow();
         
       }
       
        else if(p1.getText().equals("")){
          JOptionPane.showMessageDialog(null, "enter price ","Error!", JOptionPane.ERROR_MESSAGE);
          p1.requestFocusInWindow();
         
       }
          
       else{
        try{
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        String select = c2.getSelectedItem().toString();
        String sql = "SELECT * FROM products WHERE name = '"+select+ "'";
        ResultSet rs =  st.executeQuery(sql);
        DefaultTableModel model = (DefaultTableModel) restockTable.getModel();
        String name,id,unit,quantity,price;
        
         
        
        while(rs.next()){
               id=rs.getString(2);
               name=rs.getString(1);
               unit = rs.getString(3);
               quantity =  q2.getText();
               price = p1.getText();
          
              String[] row = {id,name,unit,quantity,price};
              model.addRow(row);      
        }
         st.close();
         conn.close();
        //to be done next
         sumTexFld1.setText(Integer.toString(restockCatSum()));
       
      }
      catch(Exception e){
          System.out.print(e.getMessage());
      }
       
       }
        
    } 
    
    
    

//All Products Table Show/Crud products
 public void allProductsTableShow(){
         //clears table if any
        DefaultTableModel dm = (DefaultTableModel) allProductsTable.getModel();
        dm.setRowCount(0);
        try{
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM products";
        ResultSet rs =  st.executeQuery(sql);
        DefaultTableModel model = (DefaultTableModel) allProductsTable.getModel();
        String id,name,unit,quantity,price;
        while(rs.next()){
               id=rs.getString(2);
               name=rs.getString(1);
               unit = rs.getString(3);
               quantity =  rs.getString(4);
               price = rs.getString(5);
               String[] row = {id,name,unit,quantity,price};
               model.addRow(row);     
        }
         st.close();
         conn.close();
        
        
       
      }
      catch(Exception e){
          System.out.print(e.getMessage());
      }
       
       
        
    } 
        
    
    
    
    //sell products
public void sellProduct(){
    
    DefaultTableModel model = (DefaultTableModel) catTable.getModel();
    int row_count =  model.getRowCount();
    if(row_count<1){
    JOptionPane.showMessageDialog(null, "There's no product added to cat!",
      "Error!", JOptionPane.ERROR_MESSAGE);

    }
    else{
    try{
      Connection conn = getConnection();
      for(int i =0;i<model.getRowCount();i++){
          PreparedStatement insert = conn.prepareStatement("insert into sold_products (id,name,unit,quantity,total_ksh)values(?,?,?,?,?)");
          insert.setInt(1,0);//auto gen in db
          insert.setString(2,model.getValueAt(i, 1).toString());
          insert.setString(3,model.getValueAt(i, 2).toString());
          insert.setInt(4,Integer.parseInt(model.getValueAt(i, 3).toString()));
          insert.setFloat(5,Float.parseFloat(model.getValueAt(i,4).toString()));
          insert.executeUpdate();
          //seardch for product being sold
          Statement st = conn.createStatement();
          String sql = "SELECT * FROM products WHERE id = '"+model.getValueAt(i, 0).toString()+ "'";
          ResultSet rs =  st.executeQuery(sql);
          //update quantity of the product
          if(rs.next()){
           int q = Integer.parseInt(rs.getString(4))-Integer.parseInt(model.getValueAt(i, 3).toString());
          String q1 =  String.valueOf(q);
          String sql1 = "UPDATE products set quantity='"+q1+"' WHERE id ='"+model.getValueAt(i, 0).toString()+"' ";
           st.executeUpdate(sql1);
          }
          JOptionPane.showMessageDialog(this, "transaction succesful!");
          model.setRowCount(0);
          displayAllProductstable();
        st.close();
      }
      conn.close();
    }
  
      catch(SQLException e){
       System.out.println(e.getMessage());
      }
        
    
    }
      
      
      
}




//restock products
public void restockProducts(){
    
    DefaultTableModel model = (DefaultTableModel) restockTable.getModel();
    int row_count =  model.getRowCount();
    if(row_count<1){
    JOptionPane.showMessageDialog(null, "There's no product added yet",
      "Error!", JOptionPane.ERROR_MESSAGE);

    }
    else{
    try{
      Connection conn = getConnection();
      for(int i =0;i<model.getRowCount();i++){
          PreparedStatement insert = conn.prepareStatement("insert into restocked_products (id,name,unit,quantity,price)values(?,?,?,?,?)");
          insert.setInt(1,0);//auto gen in db
          insert.setString(2,model.getValueAt(i, 1).toString());
          insert.setString(3,model.getValueAt(i, 2).toString());
          insert.setInt(4,Integer.parseInt(model.getValueAt(i, 3).toString()));
          insert.setFloat(5,Float.parseFloat(model.getValueAt(i,4).toString()));
          insert.executeUpdate();
          //seardch for product being sold
          Statement st = conn.createStatement();
          String sql = "SELECT * FROM products WHERE id = '"+model.getValueAt(i, 0).toString()+ "'";
         
          ResultSet rs =  st.executeQuery(sql);
          //update quantity of the product
          if(rs.next()){
          int q = Integer.parseInt(rs.getString(4))+Integer.parseInt(model.getValueAt(i, 3).toString());
          String q1 =  String.valueOf(q);
          float pr = Float.parseFloat(model.getValueAt(i,4).toString());
          String sql1 = "UPDATE products set quantity='"+q1+"', price='"+pr+"' WHERE id ='"+model.getValueAt(i, 0).toString()+"' ";
           st.executeUpdate(sql1);
          }
          JOptionPane.showMessageDialog(this, "transaction succesful!");
          model.setRowCount(0);
          displayAllProductstable();
        st.close();
      }
      conn.close();
    }
  
      catch(SQLException e){ 
       System.out.println(e.getMessage());
      }
        
    
    }
      
      
      
}







//search on crud products table
public void serchedCrudProductstable(){
                
                if(srchFld.getText().equals("") || srchFld.getText().equalsIgnoreCase("name or id")){
                JOptionPane.showMessageDialog(this, "you must enter name or id of product!","Error!", JOptionPane.ERROR_MESSAGE);
                }
                
     
                else{
                
                try {
                     //clears table if any
                DefaultTableModel dm = (DefaultTableModel) allProductsTable.getModel();
                dm.setRowCount(0);
              
              Connection conn = getConnection();
              Statement st = conn.createStatement();
              String query = "";
              String searchItem = srchFld.getText();
              if(searchItem.matches("\\d+")){//check if its an id input
              query = "SELECT * FROM products WHERE id = '"+searchItem + "'";
              }
              if(!searchItem.matches("\\d+")){
              query = "SELECT * FROM products WHERE name LIKE '%' '"+ searchItem +"' '%'";
              }
              ResultSet rs =  st.executeQuery(query);
              if(rs.isBeforeFirst()){
              DefaultTableModel model = (DefaultTableModel) allProductsTable.getModel();
              String id,name,unit,quantity,price;
              while(rs.next()){
              name=rs.getString(1);
              id=rs.getString(2);
              unit = rs.getString(3);
              quantity =rs.getString(4);
              price = rs.getString(5);
              String[] row = {id,name,unit,quantity,price};
              model.addRow(row);
              
              }
              st.close();
              conn.close();
              }
              else{
              JOptionPane.showMessageDialog(this, "search item not found!");
              }
              
             
              System.out.println("DB connected!");
          } 
          catch (SQLException ex) {
               System.out.println(ex.getMessage());
               System.out.println("mySQL error");
              Logger.getLogger(addB1.class.getName()).log(Level.SEVERE, null, ex);
          }
                    
                }
     
    }


//method to search user already exists
    public boolean searchByUserName(String sname){
      boolean check = false;
      
      try{
        Connection conn = getConnection(); 
        Statement st = conn.createStatement();
        String sql = "SELECT username FROM users WHERE username = '"+sname + "'";
        ResultSet result =  st.executeQuery(sql);
        if(result.isBeforeFirst()){
        check = true;
        }
        st.close();
        conn.close();
      }
      catch(Exception e){
          System.out.print(e.getMessage());
      }
     
      return check;
      
         }
    
    public void createUser(){
         String user  =  userName.getText();
         String p =   String.valueOf(passwordP.getPassword());
         String c = roleC.getSelectedItem().toString();
          if(userName.getText().equalsIgnoreCase("")|| String.valueOf(passwordP.getPassword()).equalsIgnoreCase("")){
          JOptionPane.showMessageDialog(this, "username and password required!","Error!", JOptionPane.ERROR_MESSAGE);
          }
          
          else if(user.indexOf(' ') != -1){
              JOptionPane.showMessageDialog(this, "username must be one word!","Error!", JOptionPane.ERROR_MESSAGE);
              userName.requestFocus();
          }
          else if(p.length()<4){
              JOptionPane.showMessageDialog(this, "password must be at least 4 characters!","Error!", JOptionPane.ERROR_MESSAGE);
              passwordP.requestFocus();
          }
          
          else if(searchByUserName(user)){//check if product exists
            JOptionPane.showMessageDialog(this, "user with username "+" "+user+"   already exists!","Error!", JOptionPane.ERROR_MESSAGE);
          }
          else{
           try {  
           Connection conn =  getConnection();
            statement = conn.createStatement();
            PreparedStatement insert = conn.prepareStatement("insert into users (id,username,password,role)values(?,?,?,?)");
            insert.setInt(1,0);//auto gen in db
            insert.setString(2,user);
            insert.setString(3,p);
            insert.setString(4,c);
            insert.executeUpdate();
            JOptionPane.showMessageDialog(this, "User Successfuly Created!");

          //clear fields
          userName.setText("");
          passwordP.setText("");
          
          //displayAllProductstable();
          
          System.out.print("Database Connected");
          statement.close();
          conn.close();
     }
      catch(SQLException ex){
      
          System.out.print(ex.getMessage());
     }  
          
          
          
          
          }
         
        
    
    
    }
    
    
    
    
//users manage table
 public void usersTableShow(){
         //clears table if any
        DefaultTableModel dm = (DefaultTableModel) usersTable.getModel();
        dm.setRowCount(0);
        try{
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM users";
        ResultSet rs =  st.executeQuery(sql);
        DefaultTableModel model = (DefaultTableModel) usersTable.getModel();
        String id,username,role,password;
        while(rs.next()){
               id=rs.getString(1);
               username=rs.getString(2);
               role = rs.getString(4);
               password = rs.getString(3);
               String[] row = {id,username,role,password};
               model.addRow(row);     
        }
         st.close();
         conn.close();
        
        
       
      }
      catch(Exception e){
          System.out.print(e.getMessage());
      }
       
       
        
    } 
//update user details
 
 public boolean roleValidator(String role){
    boolean check =  false;
    String [] roles = {"admin","normal"};
    for(int i =0;i<roles.length;i++){
    if(role.equals(roles[i])){
    check = true;
    break;
    }
    }
    return check;
 }
 
 public void upDateUser(){
       JDialog.setDefaultLookAndFeelDecorated(true);
       if(editUserName.getText().equalsIgnoreCase("")||editUserRole.getText().equalsIgnoreCase("")){
       JOptionPane.showMessageDialog(this, "select user and click edit first!","Error!", JOptionPane.ERROR_MESSAGE);
       
       }
      else if(!roleValidator(editUserRole.getText())){
         JOptionPane.showMessageDialog(this, "role must either be normal or admin","Error!", JOptionPane.ERROR_MESSAGE);
       }
       else
      {
          
           try{
          Connection conn =  getConnection();
          Statement st = conn.createStatement();
          String sql = "UPDATE users set username='"+editUserName.getText()+"', password='"+editUserPassword.getText()+"', role='"+editUserRole.getText()+"'  WHERE id ='"+usersTable.getValueAt(usersTable.getSelectedRow(), 0).toString()+"' ";
          st.executeUpdate(sql);
          JOptionPane.showMessageDialog(this, "User Successfuly Updated!");
          editUserName.setText("");
          editUserPassword.setText("");
          editUserRole.setText("");
          usersTableShow();
          
      }
      catch(Exception e){
          
          JOptionPane.showMessageDialog(this, "user not updated!","Error!", JOptionPane.ERROR_MESSAGE);
          System.out.println(e.getMessage());
      }
      
      
      
      }
     
      
 
 }
 
    
    


    
    
    
    
          //action listeners
    @Override
    public void actionPerformed(ActionEvent e){
        JDialog.setDefaultLookAndFeelDecorated(true);
         
        //add new products
     if(e.getSource()==addProdButton){
         
          if (productName.getText().equals("")
                  ||productQuantity.getText().equals("")||productUnit.getText().equals("")
                  ||productPrice.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter all fields!","Error!", JOptionPane.ERROR_MESSAGE);
        }
          else if(searchByName(productName.getText())){//check if product exists
            JOptionPane.showMessageDialog(this, "Product with name "+" "+productName.getText()+"   already exists!","Error!", JOptionPane.ERROR_MESSAGE);
          }
          else{
                       //vriables
      String name =productName.getText();
      //int  id =Integer.parseInt(productId.getText());
      String unit = productUnit.getText();
      int  quantity =Integer.parseInt(productQuantity.getText());
      float price = Float.parseFloat(productPrice.getText());
        
       
          try {  
         Connection conn =  getConnection();
         statement = conn.createStatement();
         PreparedStatement insert = conn.prepareStatement("insert into products (name,id,unit,quantity,price)values(?,?,?,?,?)");
          insert.setString(1,name);
          insert.setInt(2,0);//auto gen in db
          insert.setString(3,unit);
          insert.setInt(4,quantity);
          insert.setFloat(5,price);
          insert.executeUpdate();
          JOptionPane.showMessageDialog(this, "Product Successfuly Added");
          
          //clear fields
          productName.setText("");
          //productId.setText("");
          productUnit.setText("");
          productQuantity.setText("");
          productPrice.setText("");
          
          displayAllProductstable();
          
          System.out.print("Database Connected");
          statement.close();
          conn.close();
     }
      catch(SQLException ex){
          System.out.println("Db not connected!");
          System.out.print(ex.getMessage());
     }  
          }

 

    }
     
     //display allproducts
     if(e.getSource()==displayButton1){
        displayAllProductstable();
     }
     
     
     //clear products 
     if(e.getSource()==clearButton1){
      table1.setModel(new DefaultTableModel());
     }
     
     
     //dispaya only seached products
     
     if(e.getSource()==searchB1){
     displaySearchedProductstable();
     }
     
     //add product to cat
     
     if(e.getSource()==addB1){
           
           addToCat();
     }
     
     if(e.getSource()==sellB1){
     sellProduct();
     }
     if(e.getSource()==loadAllB){ 
       allProductsTableShow();
     }
     
     if(e.getSource()==searchAllB){
     serchedCrudProductstable();
     }
     
     if(e.getSource()==editProductB){ 
         //check product not picked
         if(allProductsTable.getSelectedRow()<0){
         JOptionPane.showMessageDialog(null, "you must select product","Error!", JOptionPane.ERROR_MESSAGE);
         }
         else{
          //read selected data
         editName.setText(allProductsTable.getValueAt(allProductsTable.getSelectedRow(), 1).toString());
         editUnit.setText(allProductsTable.getValueAt(allProductsTable.getSelectedRow(), 2).toString());
         editQuantity.setText(allProductsTable.getValueAt(allProductsTable.getSelectedRow(), 3).toString());
         editPrice.setText(allProductsTable.getValueAt(allProductsTable.getSelectedRow(), 4).toString());
         
         }
    
     }
     
     if(e.getSource()==saveB){
         
      
      if(editName.getText().equals("")||editUnit.getText().equals("")||editQuantity.getText().equals("")
              ||editPrice.getText().equals("")||allProductsTable.getSelectedRow()<0){
          JOptionPane.showMessageDialog(null, "press edit button","Error!", JOptionPane.ERROR_MESSAGE);
      }
      else{
          try{
           int  quantity =Integer.parseInt(editQuantity.getText());
           float price = Float.parseFloat(editPrice.getText());
           int id = Integer.parseInt(allProductsTable.getValueAt(allProductsTable.getSelectedRow(), 0).toString());   
           Connection conn =  getConnection();
           String sql = "UPDATE products set name='"+editName.getText()+"', unit='"+editUnit.getText()+"', quantity='"+quantity+"',  price='"+price+"'  WHERE id ='"+id+"' ";
           Statement st = conn.createStatement();
           st.executeUpdate(sql);
           editName.setText("");
           editUnit.setText("");
           editQuantity.setText("");
           editPrice.setText("");
           allProductsTableShow();//reload the table
           JOptionPane.showMessageDialog(this, "Product Updated Succesfuly");
          }
          catch(SQLException ex){
          System.out.println(ex.getMessage());
          }
      
      }
      
      
     
     }
     
     
     if(e.getSource()==deleteB){
        if(allProductsTable.getSelectedRow()<0){
        JOptionPane.showMessageDialog(this, "select product","Error!",JOptionPane.ERROR_MESSAGE);
        }
        else{
        try{
            Connection conn =  getConnection();
            Statement st = conn.createStatement();
            int id = Integer.parseInt(allProductsTable.getValueAt(allProductsTable.getSelectedRow(), 0).toString());
            String sql = "DELETE FROM products WHERE id = '"+id+"' ";
            String name = allProductsTable.getValueAt(allProductsTable.getSelectedRow(), 1).toString();
            //confirm
            JDialog.setDefaultLookAndFeelDecorated(true);
            int response = JOptionPane.showConfirmDialog(null, "Do you want to delete "+name+" ?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION){
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, " "+name+" deleted ");
            allProductsTableShow();
        }
                
            
        } 
          
        catch(SQLException ex){
          System.out.println(ex.getMessage());
          }
            
            
        }
     
     }
     
     if(e.getSource()==addB2){
      addToRestockTable();
     }
     
     if(e.getSource()==restockB1){
     restockProducts();
     }
     
     if(e.getSource()==createUserB){
     
     createUser();
     usersTableShow();
     }
     
     if(e.getSource()==editUserB){
     upDateUser();
     
     }
     
     
     
    }
    
    
    
    
    public static void main(String[] args) {
      
       
       if(isAuthenticated){
        new addB1();
       }
       else{
           new loginPage();
       }
       
}

}
