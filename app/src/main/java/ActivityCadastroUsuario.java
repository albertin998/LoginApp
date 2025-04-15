public class ActivityCadastroUsuario extends AppCompatActivity {
    private EditText editNome, editEmail, editSenha, editConfirmarSenha;
    private Button btnSalvarCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        editNome = findViewById(R.id.editNome);
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        editConfirmarSenha = findViewById(R.id.editConfirmarSenha);
        btnSalvarCadastro = findViewById(R.id.btnSalvarCadastro);

        btnSalvarCadastro.setOnClickListener(v -> {
            if (!editSenha.getText().toString().equals(editConfirmarSenha.getText().toString())) {
                abrirTelaErro("As senhas não coincidem!");
            } else {

                Toast.makeText(this, "Usuário cadastrado!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void abrirTelaErro(String mensagem) {
        Intent intent = new Intent(this, ActivityErro.class);
        intent.putExtra("mensagem", mensagem);
        startActivity(intent);
    }
}
