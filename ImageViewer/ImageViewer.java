import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImageViewer extends JFrame {
    private JPanel imagePanel;
    private JButton openButton, nextButton, prevButton;
    private File[] images;
    private int currentIndex = 0;

    public ImageViewer() {
        setTitle("Image Viewer");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        imagePanel = new JPanel();
        openButton = new JButton("Open");
        nextButton = new JButton("Next");
        prevButton = new JButton("Previous");

        // Layout dan event listener
        setLayout(new BorderLayout());
        add(imagePanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);

        openButton.addActionListener(e -> openImages());
        nextButton.addActionListener(e -> nextImage());
        prevButton.addActionListener(e -> prevImage());
    }

    private void openImages() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File dir = chooser.getSelectedFile();
            images = dir.listFiles((file, name) -> name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png"));
            if (images != null && images.length > 0) {
                currentIndex = 0;
                displayImage();
            }
        }
    }

    private void displayImage() {
        if (images != null && currentIndex >= 0 && currentIndex < images.length) {
            ImageIcon icon = new ImageIcon(images[currentIndex].getAbsolutePath());
            Image img = icon.getImage().getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(), Image.SCALE_SMOOTH);
            imagePanel.removeAll();
            imagePanel.add(new JLabel(new ImageIcon(img)));
            imagePanel.revalidate();
            imagePanel.repaint();
        }
    }

    private void nextImage() {
        if (images != null && currentIndex < images.length - 1) {
            currentIndex++;
            displayImage();
        }
    }

    private void prevImage() {
        if (images != null && currentIndex > 0) {
            currentIndex--;
            displayImage();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ImageViewer());
    }
}
