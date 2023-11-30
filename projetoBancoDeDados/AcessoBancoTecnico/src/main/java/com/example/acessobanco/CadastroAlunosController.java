package com.example.acessobanco;

import com.example.acessobanco.database.AlunoDAO;
import com.example.acessobanco.database.entidades.Aluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CadastroAlunosController {

    @FXML
    private VBox root;

    @FXML
    private TableView<Aluno> tableAlunos;

    @FXML
    private TableColumn<Aluno, Integer> colunaId;

    @FXML
    private TableColumn<Aluno, String> colunaNome;

    @FXML
    private TableColumn<Aluno, Double> colunaPeso;

    @FXML
    private TableColumn<Aluno, String> colunaCpf;

    @FXML
    private TextField nomeText;

    @FXML
    private TextField pesoText;

    @FXML
    private TextField cpfText;



    @FXML
    private TextField pesquisaPorIdText;

    @FXML
    private Button sairModoEdicaoButton;

    @FXML
    private Label modoLabel;

    private Stage stage;

    private boolean modoEdicao;

    private Aluno alunoEmEdicao;

    @FXML
    protected void initialize() throws Exception {
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colunaPeso.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        setModoInsercao();
        mostrarTodosAlunos();
    }

    @FXML
    protected void onSalvarButtonClick() throws Exception {
        int quantidadeModificacoes = 0;
        String nome = nomeText.getText();
        double peso = Double.parseDouble(pesoText.getText());
        String cpf =  cpfText.getText();
        if(modoEdicao){
            alunoEmEdicao.setNome(nome);
            alunoEmEdicao.setPeso(peso);
            alunoEmEdicao.setCpf(cpf);
            quantidadeModificacoes = AlunoDAO.atualiza(alunoEmEdicao);
        }else{
            Aluno aluno = new Aluno(nome, peso, cpf);
            quantidadeModificacoes = AlunoDAO.insere(aluno);
        }

        if(quantidadeModificacoes > 0){
            mostrarTodosAlunos();
            setModoInsercao();
            limpaCampos();

        }
    }

    @FXML
    protected void onExcluirButtonClick() throws Exception {
        Aluno aluno = tableAlunos.getSelectionModel().getSelectedItem();
        if(aluno != null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Exclusão");
            alert.setHeaderText("Você solicitou a exclusão do aluno de id " + aluno.getId() + " (" + aluno.getNome() + ")");
            alert.setContentText("Confirma a exclusão?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                int quantidadeModificacoes = AlunoDAO.exclui(aluno);
                if(quantidadeModificacoes > 0){
                    mostrarTodosAlunos();
                    setModoInsercao();
                }
            }
        }
    }

    @FXML
    protected void onSairModoEdicaoButtonClick(){
        setModoInsercao();
        limpaCampos();
    }

    @FXML
    protected void onPesquisaPorIdButtonClick() throws Exception {
        int idBusca = Integer.parseInt(pesquisaPorIdText.getText());
        Aluno aluno = AlunoDAO.obterPorId(idBusca);
        if(aluno != null){
            List<Aluno> alunos = new ArrayList<>();
            alunos.add(aluno);
            carregaTabela(alunos);
            limpaCampos();
        }
    }

    @FXML
    protected void onEditarButtonClick(){
        Aluno aluno = tableAlunos.getSelectionModel().getSelectedItem();
        if(aluno != null){
            setModoEdicao(aluno);
        }
    }

    @FXML
    protected void onPesquisaTodosButtonClick() throws Exception {
        mostrarTodosAlunos();
    }

    @FXML
    protected void onSairButtonClick(){
        fecharJanela();
    }

    private void carregaTabela(List<Aluno> alunos) throws Exception {
        ObservableList<Aluno> alunoList = FXCollections.observableArrayList();
        alunoList.addAll(alunos);
        tableAlunos.setItems(alunoList);
    }

    private void mostrarTodosAlunos() throws Exception {
        List<Aluno> alunos = AlunoDAO.obterTodos();
        carregaTabela(alunos);
    }

    private void limpaCampos(){
        nomeText.setText("");
        pesoText.setText("");
        pesquisaPorIdText.setText("");
        cpfText.setText("");
    }

    private void setModoEdicao(Aluno aluno){
        modoEdicao = true;
        modoLabel.setText("Modo: edição");
        nomeText.setText(aluno.getNome());
        pesoText.setText(String.valueOf(aluno.getPeso()));
        cpfText.setText(aluno.getCpf());
        alunoEmEdicao = aluno;
        sairModoEdicaoButton.setVisible(true);
    }

    private void setModoInsercao(){
        modoEdicao = false;
        modoLabel.setText("Modo: inserção");
        sairModoEdicaoButton.setVisible(false);
    }

    private void fecharJanela(){
        ((Stage) root.getScene().getWindow()).close();
    }

}
