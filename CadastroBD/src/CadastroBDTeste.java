import model.PessoaFisica;
import model.PessoaFisicaDAO;
import model.PessoaJuridica;
import model.PessoaJuridicaDAO;
import model.util.ConectorBD;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;

public class CadastroBDTeste {
    public static void main(String[] args) {
        try {
            Connection conn = ConectorBD.getConnection();
            PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
            PessoaJuridicaDAO pjDAO = new PessoaJuridicaDAO();

            PessoaFisica pf = new PessoaFisica(6, "Filipe", "Rua Um, 10", "Resende", "RJ",
                    "1234-1234", "filipe@email.com", "12345678910");

            pfDAO.incluir(pf);
            System.out.println("Pessoa fisica criada:");
            pf.exibir();
            System.out.println();

            pfDAO.alterar(pf, "Filipe Alterado", "Rua Dois, 20", "Araguari", "MG",
                    "9999-8888", "filipealterado@email.com", "12345678911");
            System.out.println("--------------------");
            System.out.println("Dados da pessoa fisica alterados.");
            System.out.println("--------------------");
            System.out.println();

            List<PessoaFisica> pessoasFisicas = pfDAO.getPessoas();
            System.out.println("Todas as pessoas fisicas:");
            for (PessoaFisica pessoaFisica : pessoasFisicas) {
                pessoaFisica.exibir();
            }
            System.out.println();

            System.out.println("--------------------");
            pfDAO.excluir(pf.getId());
            System.out.println("--------------------");
            System.out.println();

            PessoaJuridica pj = new PessoaJuridica(7, "Empresa Um", "Avenida Legal, 10",
                    "Sao Paulo", "SP", "1234-1234", "empresalegal@email.com", "123456789101");

            pjDAO.incluir(pj);
            System.out.println("Pessoa juridica criada:");
            pj.exibir();
            System.out.println();

            pjDAO.alterar(pj, "Empresa Mais legal", "Aveniada Dois, 20", "Rio de Janeiro", "RJ",
                    "4444-4444", "empresamais@email.com", "10987654321");
            System.out.println("--------------------");
            System.out.println("Dados da pessoa juridica alterados.");
            System.out.println("--------------------");
            System.out.println();

            List<PessoaJuridica> pessoasJuridicas = pjDAO.getPessoas();
            System.out.println("Todas as pessoas juridicas:");
            for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
                pessoaJuridica.exibir();
            }
            System.out.println();

            System.out.println("--------------------");
            pjDAO.excluir(pj.getId());
            System.out.println("--------------------");
            System.out.println();

            ConectorBD.close(conn);

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}
