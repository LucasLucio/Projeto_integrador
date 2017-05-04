package GUI;

import java.awt.BorderLayout;
import DAOs.DAOPessoa;
import Entidades.Pessoa;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class GUI_Pessoa extends JDialog {

    private Container cp;
    private JPanel pnNorte = new JPanel(new FlowLayout());
    private JPanel pnCentro = new JPanel(new GridLayout(0, 2));
    private JPanel pnSul = new JPanel(new FlowLayout());

    private JLabel lbIdPessoa = new JLabel("IdPessoa:");
    private JTextField tfIdPessoa = new JTextField(10);

    private JButton btBuscar = new JButton("Buscar");
    private JButton btInserir = new JButton("Criar");
    private JButton btSalvar = new JButton("Salvar");
    private JButton btCancelar = new JButton("Cancelar");
    private JButton btRemover = new JButton("Remover");
    private JButton btAtualizar = new JButton("Atualizar");
    private JButton btListar = new JButton("Listar");
    
    private JLabel lbAviso = new JLabel("Aviso");
    DAOPessoa controle = new DAOPessoa();
    List<Pessoa> dados = new ArrayList<>();
    
    private boolean acao = true;
    Pessoa entidade = new Pessoa();

    private JLabel lbRg = new JLabel("Rg");
    private JTextField tfRg = new JTextField();

    private JLabel lbCpf = new JLabel("Cpf");
    private JTextField tfCpf = new JTextField();

    private JLabel lbTelefone = new JLabel("Telefone");
    private JTextField tfTelefone = new JTextField();

    private JLabel lbEmail = new JLabel("Email");
    private JTextField tfEmail = new JTextField();

    private JLabel lbIdade = new JLabel("Idade");
    private JTextField tfIdade = new JTextField();

    private JLabel lbSexo = new JLabel("Sexo");
    private JTextField tfSexo = new JTextField();

    private JDialog dialog = new JDialog();
    private JTextArea text = new JTextArea();
    private JScrollPane scroll = new JScrollPane(text);
    private Integer IdPessoa;
    public GUI_Pessoa() {

        setSize(800, 700);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("");

        pnNorte.setBackground(Color.lightGray);
        pnCentro.setBackground(Color.lightGray);
        pnSul.setBackground(Color.lightGray);

        dialog.add(scroll);
        text.setEditable(false);
        dialog.setSize(500,200);

        pnNorte.add(lbIdPessoa);
        pnNorte.add(tfIdPessoa);
        pnNorte.add(btBuscar);
        pnNorte.add(btInserir);
        pnNorte.add(btSalvar);
        pnNorte.add(btCancelar);
        pnNorte.add(btRemover);
        pnNorte.add(btAtualizar);
        pnNorte.add(btListar);
        btInserir.setVisible(false);
        btSalvar.setVisible(false);
        btCancelar.setVisible(false);
        btRemover.setVisible(false);
        btAtualizar.setVisible(false);

        pnSul.add(lbAviso);
        lbAviso.setOpaque(true);

        cp.add(pnNorte, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);
        cp.add(pnSul, BorderLayout.SOUTH);


        tfRg.setEnabled(false);
        pnCentro.add(lbRg);
        pnCentro.add(tfRg);

        tfCpf.setEnabled(false);
        pnCentro.add(lbCpf);
        pnCentro.add(tfCpf);

        tfTelefone.setEnabled(false);
        pnCentro.add(lbTelefone);
        pnCentro.add(tfTelefone);

        tfEmail.setEnabled(false);
        pnCentro.add(lbEmail);
        pnCentro.add(tfEmail);

        tfIdade.setEnabled(false);
        pnCentro.add(lbIdade);
        pnCentro.add(tfIdade);

        tfSexo.setEnabled(false);
        pnCentro.add(lbSexo);
        pnCentro.add(tfSexo);


        btBuscar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    entidade = new Pessoa();

                    IdPessoa = Integer.valueOf(tfIdPessoa.getText());

                    entidade.setIdPessoa(IdPessoa);

                    if (IdPessoa<= 0) {
                        int error = 3/0;
                    }
                    entidade = controle.obter(entidade.getIdPessoa());
                    pnSul.setBackground(Color.green);
                    if (entidade != null) {

                        btInserir.setVisible(false);
                        btAtualizar.setVisible(true);
                        btRemover.setVisible(true);
                        lbAviso.setText("Achou na lista");

                        tfRg.setText(entidade.getRg());

                        tfCpf.setText(entidade.getCpf());

                        tfTelefone.setText(entidade.getTelefone());

                        tfEmail.setText(entidade.getEmail());

                        tfIdade.setText(String.valueOf(entidade.getIdade()));

                        tfSexo.setText(entidade.getSexo());

                    } else {
                        lbAviso.setText("Não achou na lista");
                        btInserir.setVisible(true);

                        pnSul.setBackground(Color.red);
                        btAtualizar.setVisible(false);
                        btRemover.setVisible(false);


                        tfRg.setEnabled(false);

                        tfCpf.setEnabled(false);

                        tfTelefone.setEnabled(false);

                        tfEmail.setEnabled(false);

                        tfIdade.setEnabled(false);

                        tfSexo.setEnabled(false);

                    }

                } catch (Exception err) {
                    lbAviso.setText("Erro nos dados");
                    pnSul.setBackground(Color.red);
                }

            }
        }
        );

        btInserir.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        acao = true;
                        btBuscar.setVisible(false);
                        btListar.setVisible(false);

                        tfIdPessoa.setText(String.valueOf(IdPessoa));
                        tfIdPessoa.setEnabled(false);

                        tfRg.setEnabled(true);
                        tfRg.setText(String.valueOf(""));

                        tfCpf.setEnabled(true);
                        tfCpf.setText(String.valueOf(""));

                        tfTelefone.setEnabled(true);
                        tfTelefone.setText(String.valueOf(""));

                        tfEmail.setEnabled(true);
                        tfEmail.setText(String.valueOf(""));

                        tfIdade.setEnabled(true);
                        tfIdade.setText(String.valueOf(""));

                        tfSexo.setEnabled(true);
                        tfSexo.setText(String.valueOf(""));

                        tfRg.requestFocus();


                        btInserir.setVisible(false);
                        btSalvar.setVisible(true);
                        btCancelar.setVisible(true);
                        btRemover.setVisible(false);
                        btAtualizar.setVisible(false);
                    }
                }
        );

        btSalvar.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        if (acao) {
                            try{

                            Pessoa entidade = new Pessoa();

                            entidade.setIdPessoa(IdPessoa);

                            entidade.setRg(tfRg.getText());

                            entidade.setCpf(tfCpf.getText());

                            entidade.setTelefone(tfTelefone.getText());

                            entidade.setEmail(tfEmail.getText());

                            entidade.setIdade(Integer.valueOf(tfIdade.getText()));

                            entidade.setSexo(tfSexo.getText());

                            controle.inserir(entidade);

                            lbAviso.setText("Registro inserido");
                            btSalvar.setVisible(false);
                            btCancelar.setVisible(false);
                            btBuscar.setVisible(true);
                            btListar.setVisible(true);
                            tfIdPessoa.setEnabled(true);
                            tfIdPessoa.requestFocus();
                            tfIdPessoa.selectAll();

                            tfRg.setEnabled(false);

                            tfCpf.setEnabled(false);

                            tfTelefone.setEnabled(false);

                            tfEmail.setEnabled(false);

                            tfIdade.setEnabled(false);

                            tfSexo.setEnabled(false);

                            pnSul.setBackground(Color.green);
                }catch (Exception btSalvar){
                    JOptionPane.showMessageDialog(null, "ERRO NOS DADOS", "ERROR", JOptionPane.ERROR_MESSAGE);}

                        } else {
                            try{
                            Pessoa entidadeOriginal = entidade;
                            Pessoa entidadeModificada = new Pessoa();

                            entidadeModificada.setIdPessoa(IdPessoa);

                            entidadeModificada.setRg(tfRg.getText());

                            entidadeModificada.setCpf(tfCpf.getText());

                            entidadeModificada.setTelefone(tfTelefone.getText());

                            entidadeModificada.setEmail(tfEmail.getText());

                            entidadeModificada.setIdade(Integer.valueOf(tfIdade.getText()));

                            entidadeModificada.setSexo(tfSexo.getText());


                            controle.atualizar(entidadeModificada);

                            lbAviso.setText("Registro alterado");
                            tfIdPessoa.setEnabled(true);
                            tfIdPessoa.requestFocus();
                            tfIdPessoa.selectAll();
                            btSalvar.setVisible(false);
                            btCancelar.setVisible(false);
                            btBuscar.setVisible(true);
                            btListar.setVisible(true);

                            tfRg.setEnabled(false);

                            tfCpf.setEnabled(false);

                            tfTelefone.setEnabled(false);

                            tfEmail.setEnabled(false);

                            tfIdade.setEnabled(false);

                            tfSexo.setEnabled(false);

                            pnSul.setBackground(Color.green);
                            }catch (Exception btSalvarAtt){
                                JOptionPane.showMessageDialog(null, "ERRO NOS DADOS", "ERROR", JOptionPane.ERROR_MESSAGE);}


                        }
                    }
                }
        );

        btCancelar.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        lbAviso.setText("Cancelado");
                        tfIdPessoa.setEnabled(true);

                        tfIdPessoa.requestFocus();
                        tfIdPessoa.selectAll();

                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                        pnSul.setBackground(Color.green);

                        tfRg.setEnabled(false);
                        tfRg.setText(String.valueOf(""));

                        tfCpf.setEnabled(false);
                        tfCpf.setText(String.valueOf(""));

                        tfTelefone.setEnabled(false);
                        tfTelefone.setText(String.valueOf(""));

                        tfEmail.setEnabled(false);
                        tfEmail.setText(String.valueOf(""));

                        tfIdade.setEnabled(false);
                        tfIdade.setText(String.valueOf(""));

                        tfSexo.setEnabled(false);
                        tfSexo.setText(String.valueOf(""));

                    }
                }
        );

        btAtualizar.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        acao = false;

                        tfIdPessoa.setText(String.valueOf(IdPessoa));
                        tfIdPessoa.setEnabled(false);

                        tfRg.setEnabled(true);

                        tfCpf.setEnabled(true);

                        tfTelefone.setEnabled(true);

                        tfEmail.setEnabled(true);

                        tfIdade.setEnabled(true);

                        tfSexo.setEnabled(true);

                        tfRg.requestFocus();

                        btSalvar.setVisible(true);
                        btCancelar.setVisible(true);
                        btBuscar.setVisible(false);
                        btListar.setVisible(false);
                        btRemover.setVisible(false);
                        btAtualizar.setVisible(false);

                    }
                }
        );

        btRemover.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        btRemover.setVisible(false);
                        btAtualizar.setVisible(false);
                        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                                "Confirma a exclusão do registro <ID = " + entidade.getIdPessoa() + ">?", "Confirm",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {


                        tfRg.setText(String.valueOf(""));

                        tfCpf.setText(String.valueOf(""));

                        tfTelefone.setText(String.valueOf(""));

                        tfEmail.setText(String.valueOf(""));

                        tfIdade.setText(String.valueOf(""));

                        tfSexo.setText(String.valueOf(""));

                        tfIdPessoa.requestFocus();
                        tfIdPessoa.setEnabled(true);
                        tfIdPessoa.setText(String.valueOf(""));
                        controle.remover(entidade);
                        lbAviso.setText("Removeu");


                        } else {
                            lbAviso.setText("Cancelada a remoção");
                            btRemover.setVisible(true);
                            btAtualizar.setVisible(true);
                        }

                    }
                }
        );

       btListar.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e
                    ) {
                try{
                String aux[];
                text.setText("");
                dados = controle.list();
                try{
                if (dados.get(0) == null){}
                }catch(Exception lista){
                    JOptionPane.showMessageDialog(null, "NOTHING TO SEE HERE! 8P", "OPS", JOptionPane.PLAIN_MESSAGE);
                    int erro = 3/0;                }
                for (Pessoa linha : dados) {
                    aux = String.valueOf(linha).split(";");
                    text.append(
"IdPessoa: " + 
            Integer.valueOf(aux[0])
 + "\n" +
"Rg: " + 
            aux[1]
 + "\n" +
"Cpf: " + 
            aux[2]
 + "\n" +
"Telefone: " + 
            aux[3]
 + "\n" +
"Email: " + 
            aux[4]
 + "\n" +
"Idade: " + 
            Integer.valueOf(aux[5])
 + "\n" +
"Sexo: " + 
            aux[6]
+ "\n-------------------------------------------------------------------------------------------\n"
);}
                dialog.setLocationRelativeTo(cp);
                dialog.setModal(true);
                dialog.setVisible(true);
                }catch(Exception Lista){                    }
        }});

       addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            System.exit(0);            }
        });
        
        tfIdPessoa.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
            btBuscar.doClick();}});


        setLocationRelativeTo(null);
        setModal(true);
        setVisible(true);
    }
}

