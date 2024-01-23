package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class view {
    public static void show() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Menu Bar Example");
            frame.setTitle("Trang chủ");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Tạo Menu Bar
            JMenuBar menuBar = new JMenuBar();

            // Tạo Menu "Trang Chủ"
            JMenu homeMenu = new JMenu("Trang Chủ");
            menuBar.add(homeMenu);

            // Tạo Menu "Thông Tin"
            JMenu infoMenu = new JMenu("Thông Tin");

            // Tạo các mục con cho "Thông Tin"
            JMenuItem searchItem = new JMenuItem("Tìm Kiếm");
            JMenuItem displayItem = new JMenuItem("Hiển Thị");
            JMenuItem addItem = new JMenuItem("Thêm");
            JMenuItem deleteItem = new JMenuItem("Xóa");
            JMenuItem editItem = new JMenuItem("Thay Đổi");

            // Thêm các mục con vào "Thông Tin"
            infoMenu.add(searchItem);
            infoMenu.add(displayItem);
            infoMenu.add(addItem);
            infoMenu.add(deleteItem);
            infoMenu.add(editItem);

            // Thêm "Thông Tin" vào Menu Bar
            menuBar.add(infoMenu);

            // Tạo Menu "Thống Kê"
            JMenu statisticsMenu = new JMenu("Thống Kê");

            // Tạo các mục con cho "Thống Kê"
            JMenuItem barChartItem = new JMenuItem("Biểu Đồ Cột");
            JMenuItem areaChartItem = new JMenuItem("Biểu Đồ Miền");

            // Thêm các mục con vào "Thống Kê"
            statisticsMenu.add(barChartItem);
            statisticsMenu.add(areaChartItem);

            // Thêm "Thống Kê" vào Menu Bar
            menuBar.add(statisticsMenu);

            // Tạo Menu "Đăng Xuất"
            JMenu logoutMenu = new JMenu("Đăng Xuất");
            menuBar.add(logoutMenu);

            // Đặt Menu Bar cho JFrame
            frame.setJMenuBar(menuBar);

            // Đặt JFrame là hiển thị
            frame.setVisible(true);

            // Bắt sự kiện cho mỗi mục
            searchItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Mục Tìm Kiếm Được Chọn");
                }
            });

            displayItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Mục Hiển Thị Được Chọn");
                }
            });

            addItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Mục Thêm Được Chọn");
                }
            });

            deleteItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Mục Xóa Được Chọn");
                }
            });

            editItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Mục Thay Đổi Được Chọn");
                }
            });

            barChartItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Mục Biểu Đồ Cột Được Chọn");
                }
            });

            areaChartItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Mục Biểu Đồ Miền Được Chọn");
                }
            });
        });
    }
}




