package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.userModel;
import controller.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class list {
    private static CustomListModel customListModel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowCustomList());
    }

    private static void createAndShowCustomList() {
        JFrame frame = new JFrame("Custom List Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 500);
        userModel m = new userModel();
        user[] users = m.getAllUsers();
        // Mảng dữ liệu với các đối tượng User

        // Tạo JList với mô hình tùy chỉnh
        customListModel = new CustomListModel();
        JList<user> customList = new JList<>(customListModel);
        customList.setCellRenderer(new CustomListCellRenderer());

        // Đặt kích thước cố định cho mỗi mục trong danh sách
        customList.setFixedCellWidth(400);
        customList.setFixedCellHeight(50);

        // Gọi sự kiện khi click chuột vào và kích đúp chuột
        customList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    // Xử lý sự kiện click chuột
                    int selectedIndex = customList.locationToIndex(e.getPoint());
                    if (selectedIndex != -1) {
                        User selectedUser = customListModel.getElementAt(selectedIndex);
                        System.out.println("Single click on: " + selectedUser.getName());
                    }
                } else if (e.getClickCount() == 2) {
                    // Xử lý sự kiện kích đúp chuột
                    int selectedIndex = customList.locationToIndex(e.getPoint());
                    if (selectedIndex != -1) {
                        User selectedUser = customListModel.getElementAt(selectedIndex);
                        System.out.println("Double click on: " + selectedUser.getName());
                    }
                }
            }
        });

        // Đặt JList vào JScrollPane để hỗ trợ cuộn
        JScrollPane scrollPane = new JScrollPane(customList);

        // Đặt JScrollPane vào JFrame
        frame.getContentPane().add(scrollPane);

        // Hiển thị JFrame
        frame.setVisible(true);
    }

    // Đối tượng User
    private static class User {
        private String name;
        private String phoneNumber;
        private String profession;
        private double rating;

        public User(String name, String phoneNumber, String profession, double rating) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.profession = profession;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getProfession() {
            return profession;
        }

        public double getRating() {
            return rating;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    // Mô hình tùy chỉnh
    private static class CustomListModel extends AbstractListModel<User> {
        private User[] users;

        public CustomListModel(User[] users) {
            this.users = users;
        }

        @Override
        public int getSize() {
            return users.length;
        }

        @Override
        public User getElementAt(int index) {
            return users[index];
        }
    }

    // Người vẽ tùy chỉnh cho các mục trong JList
    private static class CustomListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof User) {
                User user = (User) value;
                label.setText(user.getName() + " - " + user.getPhoneNumber() +
                        " - " + user.getProfession() + " - " + user.getRating());
            }
            return label;
        }
    }
}

