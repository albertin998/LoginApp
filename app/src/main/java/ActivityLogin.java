public class ActivityLogin extends AppCompatActivity {
    private EditText editLogin, editSenha;
    private Button btnEntrar, btnCadastrar, btnRecuperar;
    private final String USUARIO = "admin";
    private final String SENHA = "1234"; // senha hardcodepublic class LoginActivity extends AppCompatActivity {

    private EditText edtUser, edtPassword;
    private Button btnLogin, btnRegister, btnRecover;

    private final String hardcodedUser = "admin";
    private final String hardcodedPassword = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnRecover = findViewById(R.id.btnRecover);

        btnLogin.setOnClickListener(v -> {
            String user = edtUser.getText().toString();
            String password = edtPassword.getText().toString();

            if (user.isEmpty() || password.isEmpty()) {
                showError("Preencha todos os campos!");
                return;
            }

            if (user.equals(hardcodedUser) && password.equals(hardcodedPassword)) {
                startActivity(new Intent(this, ContactListActivity.class));
            } else {
                showError("Login ou senha inválidos!");
            }
        });

        btnRegister.setOnClickListener(v ->
                startActivity(new Intent(this, RegisterUserActivity.class)));

        btnRecover.setOnClickListener(v ->
                startActivity(new Intent(this, RecoverPasswordActivity.class)));
    }

    private void showError(String message) {
        Intent intent = new Intent(this, ErrorActivity.class);
        intent.putExtra("message", message);
        startActivity(intent);
    }
}
d

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editLogin = findViewById(R.id.editLogin);
        editSenha = findViewById(R.id.editSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnRecuperar = findViewById(R.id.btnRecuperar);

        btnEntrar.setOnClickListener(v -> {
            String login = editLogin.getText().toString();
            String senha = editSenha.getText().toString();
            if (login.isEmpty() || senha.isEmpty()) {
                abrirTelaErro("Preencha todos os campos!");
            } else if (login.equals(USUARIO) && senha.equals(SENHA)) {
                startActivity(new Intent(this, ActivityListaContatos.class));
            } else {
                abrirTelaErro("Login ou senha incorretos!");
            }
        });

        btnCadastrar.setOnClickListener(v -> startActivity(new Intent(this, ActivityCadastroUsuario.class)));
        btnRecuperar.setOnClickListener(v -> startActivity(new Intent(this, ActivityRecuperarSenha.class)));
    }

    private void abrirTelaErro(String mensagem) {
        Intent intent = new Intent(this, ActivityErro.class);
        intent.putExtra("mensagem", mensagem);
        startActivity(intent);
    }
}
