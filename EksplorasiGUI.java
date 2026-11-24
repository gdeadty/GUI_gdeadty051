import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EksplorasiGUI extends JFrame {

    private JTextField txtNama;
    private JLabel lblHasil;
    private JButton btnSapa;
    private JButton btnReset;

    public EksplorasiGUI() {
        setTitle("Sapaan Mahasiswa");
        setSize(420, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

        Font fontTeks = new Font("SansSerif", Font.BOLD, 13);

        JPanel panelUtama = new JPanel(new GridLayout(2, 2));

        JLabel lblNama = new JLabel("Nama:");
        lblNama.setFont(fontTeks);
        txtNama = new JTextField();
        txtNama.setFont(new Font("SansSerif", Font.PLAIN, 13));

        JLabel lblJudulHasil = new JLabel("Hasil:");
        lblJudulHasil.setFont(fontTeks);
        lblHasil = new JLabel("");
        lblHasil.setFont(fontTeks);

        panelUtama.add(lblNama);
        panelUtama.add(txtNama);
        panelUtama.add(lblJudulHasil);
        panelUtama.add(lblHasil);

        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 6));
        btnSapa = new JButton("Sapa");
        btnReset = new JButton("Reset");
        btnSapa.setFont(fontTeks);
        btnReset.setFont(fontTeks);
        panelTombol.add(btnSapa);
        panelTombol.add(btnReset);

        add(panelUtama, BorderLayout.CENTER);
        add(panelTombol, BorderLayout.SOUTH);

        btnSapa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txtNama.getText().trim();
                if (!nama.isEmpty()) {
                    lblHasil.setText("Halo, " + nama + "!");
                }
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNama.setText("");
                lblHasil.setText("");
                txtNama.requestFocus();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        EksplorasiGUI frame = new EksplorasiGUI();
        frame.setVisible(true);
    }
}