/**
 * 
 */
package candy.settings;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class SettingsGUI extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final int X_DIMENSION = 300;
    private static final int Y_DIMENSION = 250;
    private final Settings setting;

    public SettingsGUI(final Settings setting) {
        super();
        this.setTitle("Settings");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setting = setting;
        final JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new TitledBorder("Impostazioni"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 4);
        gbc.anchor = GridBagConstraints.WEST;

        final String[] choices = new String[Resolution.values().length];
        for (int i = 0; i < choices.length; i++) {
            choices[i] = Resolution.values()[i].getActualString();
        }
        final JComboBox<String> box = new JComboBox<>(choices);
        panel.add(box, gbc);
        gbc.gridy++;
        final JCheckBox sound = new JCheckBox("audio", this.setting.isSoundActive());
        panel.add(sound, gbc);
        gbc.gridx++;
        gbc.gridy++;
        final JButton saveButton = new JButton("Salva");
        saveButton.addActionListener(e -> saveSettings(sound.isSelected()));
        panel.add(saveButton, gbc);

        this.setSize(new Dimension(X_DIMENSION, Y_DIMENSION));
        this.add(panel);

        this.setResizable(false);
        this.setVisible(true);

    }

    private void saveSettings(final boolean sound) {
        this.setting.selectSoundStatus(sound);
    }


}
