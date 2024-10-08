package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Responsavel;

public class ResponsavelDao {
	public Connection getConexao() throws ClassNotFoundException {

		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);

		String url = "jdbc:mysql://localhost:3306/controle_consultorio";
		String user = "root";
		String password = "root";
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public int cadastrarResponsavel(Responsavel responsavel) {

		String insert = "INSERT INTO responsavel(nome,cpf,telefone,email) VALUES(?,?,?,?)";

		try {
			Connection conn = getConexao();

			PreparedStatement pst = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, responsavel.getNome());
			pst.setString(2, responsavel.getCpf());
			pst.setString(3, responsavel.getTelefone());
			pst.setString(4, responsavel.getEmail());

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int chaveGerada;
			if (rs.next() == true) {
				chaveGerada = rs.getInt(1);
				return chaveGerada;
			}

			rs.close();
			pst.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;

	}

	public List<Responsavel> listaDeResponsaveis() {
		List<Responsavel> responsaveis = new ArrayList<>();
		String sql = "SELECT * FROM responsavel";

		try {
			Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String telefone = rs.getString(4);
				String email = rs.getString(5);

				Responsavel responsavel = new Responsavel(id, nome, cpf, telefone, email);
				responsaveis.add(responsavel);

			}
			rs.close();
			pst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responsaveis;
	}
	
	public Responsavel pesquisarPorId(int id) {
		Responsavel responsavel = new Responsavel();
		String query = "SELECT * FROM responsavel WHERE id = ?";
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String telefone = rs.getString(4);
				String email = rs.getString(5);			
				responsavel = new Responsavel(id, nome, cpf, telefone, email);
			}
			pst.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return responsavel;
	}

	public void alterarResponsavel(Responsavel responsavel) {

		String sql = "UPDATE responsavel SET nome = ?, cpf = ?, telefone = ?, email = ?, endereco_id = ? WHERE id = ?";

		try {
			Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, responsavel.getNome());
			pst.setString(2, responsavel.getCpf());
			pst.setString(3, responsavel.getTelefone());
			pst.setString(4, responsavel.getEmail());
			pst.setInt(5, responsavel.getId());

			pst.executeUpdate();

			pst.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deletarResponsavel(int id) {
		
		String sql = "DELETE FROM responsavel WHERE id = ?";
		try {
			Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);

			pst.executeUpdate();

			pst.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
