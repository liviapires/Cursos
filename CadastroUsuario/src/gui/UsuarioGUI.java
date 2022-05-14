package gui;
import modelo.Usuario;
import dao.UsuarioDAO;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.Box;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsuarioGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCPF;
	private JTextField textFieldTelefone;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioGUI frame = new UsuarioGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UsuarioGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrodeUsuario = new JLabel("Cadastro de Usuario");
		lblCadastrodeUsuario.setBounds(12, 12, 410, 17);
		lblCadastrodeUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblCadastrodeUsuario);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 33, 226, 189);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[46px][86px,grow][46px][86px]", "[][20px][][][][][]"));
		
		JLabel lblNewLabel_3 = new JLabel("Cadastrar Novo Usuario");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNewLabel_3, "cell 0 0 2 1");
		
		JLabel lblNome = new JLabel("Nome");
		panel.add(lblNome, "cell 0 1,alignx left,aligny center");
		
		textFieldNome = new JTextField();
		panel.add(textFieldNome, "cell 1 1 2 1,growx,aligny center");
		textFieldNome.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF");
		panel.add(lblCPF, "cell 0 2,alignx left");
		
		textFieldCPF = new JTextField();
		lblCPF.setLabelFor(textFieldCPF);
		panel.add(textFieldCPF, "cell 1 2 2 1,growx,aligny center");
		textFieldCPF.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		panel.add(lblEmail, "cell 0 3,alignx left,aligny center");
		
		textFieldEmail = new JTextField();
		panel.add(textFieldEmail, "cell 1 3 2 1,growx,aligny center");
		textFieldEmail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Telefone");
		panel.add(lblNewLabel, "cell 0 4,alignx left");
		
		textFieldTelefone = new JTextField();
		lblNewLabel.setLabelFor(textFieldTelefone);
		panel.add(textFieldTelefone, "cell 1 4 2 1,growx,aligny center");
		textFieldTelefone.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuarios = new Usuario();
				usuarios.setNome(textFieldNome.getText());
				usuarios.setCpf(textFieldCPF.getText());
				usuarios.setEmail(textFieldEmail.getText());
				usuarios.setTelefone(textFieldTelefone.getText());

				if ((textFieldNome.getText().isEmpty()) || (textFieldCPF.getText().isEmpty()) || (textFieldEmail.getText().isEmpty()) || (textFieldTelefone.getText().isEmpty())) {
				   JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
				}
				else {
				    UsuarioDAO dao = new UsuarioDAO();
				    dao.adiciona(usuarios);
				    JOptionPane.showMessageDialog(null, "Usuário "+textFieldNome.getText()+" inserido com sucesso! ");
				}

				textFieldNome.setText("");
				textFieldCPF.setText("");
				textFieldEmail.setText("");
				textFieldTelefone.setText("");
			}
		});
		btnCadastrar.setToolTipText("Cadastra novo usuario");
		panel.add(btnCadastrar, "cell 1 6");
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNome.setText("");
				textFieldCPF.setText("");
				textFieldEmail.setText("");
				textFieldTelefone.setText("");
			}
		});
		btnLimpar.setToolTipText("Limpa os campos");
		panel.add(btnLimpar, "cell 2 6");
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(12, 226, 226, 23);
		contentPane.add(btnSair);
	}
}
