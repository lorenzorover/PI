package window;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem vindo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(172, 34, 84, 22);
		frame.getContentPane().add(lblNewLabel);
		
		frame.setResizable(false); // Impede redimensionamento
		
		JButton btnNewButton = new JButton("Listar Informações");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JRadioButton paciente = new JRadioButton("Pacientes");
				JRadioButton tratamento = new JRadioButton("Tratamentos");
				
				ButtonGroup grupo = new ButtonGroup();
				grupo.add(paciente);
				grupo.add(tratamento);

				JPanel painel = new JPanel(new GridLayout(4, 2));
				painel.add(paciente);
				painel.add(tratamento);

				int resultado = JOptionPane.showConfirmDialog(null, painel, "Mostrar informações", JOptionPane.OK_CANCEL_OPTION);
				
				if (resultado == JOptionPane.OK_OPTION) {
					if (paciente.isSelected()) {
						TabelaPaciente telaListaPaciente = new TabelaPaciente();
						telaListaPaciente.setVisible(true);
						telaListaPaciente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					} else if (tratamento.isSelected()){
						TabelaTratamento telaListaTratamento = new TabelaTratamento();
						telaListaTratamento.setVisible(true);
						telaListaTratamento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						
					} else {
						JOptionPane.showMessageDialog(null, "Selecione uma opção");
					}
				}
				
				
			}
		});
		btnNewButton.setBounds(10, 142, 121, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Funções do programa:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 77, 140, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				opcoesDeCadastro();
			}
		});
		btnNewButton_1.setBounds(10, 108, 121, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Estoque");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(10, 227, 121, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("<html>Conferir<br>Consultas</html>");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TabelaConsulta telaListaConsulta = new TabelaConsulta();
				telaListaConsulta.setVisible(true);
				telaListaConsulta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton_3.setBounds(10, 178, 79, 37);
		frame.getContentPane().add(btnNewButton_3);
	}
	
	public void opcoesDeCadastro() {
		
		JRadioButton paciente = new JRadioButton("Paciente");
		JRadioButton tratamento = new JRadioButton("Tratamento");
		JRadioButton consulta = new JRadioButton("Consulta");
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(paciente);
		grupo.add(tratamento);
		grupo.add(consulta);

		JPanel painel = new JPanel(new GridLayout(4, 2));
		painel.add(paciente);
		painel.add(tratamento);
		painel.add(consulta);

		int resultado = JOptionPane.showConfirmDialog(null, painel, "Cadastrar", JOptionPane.OK_CANCEL_OPTION);
		
		if (resultado == JOptionPane.OK_OPTION) {
			if (paciente.isSelected()) {
				CadastroPaciente telaCadastro = new CadastroPaciente();
				telaCadastro.setVisible(true);
				telaCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			} else if (tratamento.isSelected()){
				CadastroTratamento telaCadastro = new CadastroTratamento();
				telaCadastro.setVisible(true);
				telaCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			} else if (consulta.isSelected()){
				CadastroConsulta telaCadastro = new CadastroConsulta();
				telaCadastro.setVisible(true);
				telaCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma opção");
			}
		}
	}
	
	
	
}
