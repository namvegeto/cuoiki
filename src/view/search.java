package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class search {
    public static void show() {
        SwingUtilities.invokeLater(() -> createAndShowSearchPage());
    }

    private static void createAndShowSearchPage() {
        JFrame frame = new JFrame("Search Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);

        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(4, 2, 5, 5));

        // Tạo 3 ô nhập liệu và nút tìm kiếm
        JTextField searchField = createInputField("Enter keyword", 50);
        JTextField startDateField = createInputField("Select start date", 50);
        JTextField endDateField = createInputField("Select end date", 50);

        JButton searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(50, 20));
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý tìm kiếm dựa trên giá trị nhập vào
                String searchValue = searchField.getText();
                String startDateValue = startDateField.getText();
                String endDateValue = endDateField.getText();

                // Thêm logic xử lý tìm kiếm của bạn ở đây
                System.out.println("Search: " + searchValue);
                System.out.println("Start Date: " + startDateValue);
                System.out.println("End Date: " + endDateValue);
            }
        });

        // Thêm các thành phần vào panel
        panel.add(new JLabel("Search:"));
        panel.add(searchField);
        panel.add(new JLabel("Start Date:"));
        panel.add(startDateField);
        panel.add(new JLabel("End Date:"));
        panel.add(endDateField);
        panel.add(new JLabel("")); // Placeholder
        panel.add(searchButton);

        // Đặt panel vào JFrame
        frame.getContentPane().add(panel);

        // Hiển thị JFrame
        frame.setVisible(true);
    }

    private static JTextField createInputField(String placeholder, int columns) {
        JTextField textField = new JTextField(columns);
        textField.setText(placeholder);
        textField.setPreferredSize(new Dimension(100, 20));
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholder);
                }
            }
        });

        return textField;
    }
}
