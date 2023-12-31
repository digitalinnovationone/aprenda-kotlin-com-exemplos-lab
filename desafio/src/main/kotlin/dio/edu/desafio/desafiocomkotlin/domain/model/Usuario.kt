
@Entity (name = tb_usuario)
class Usuario

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private val id: Long?
private val name: String?
private val address: String?
private val phone: String?
private val email: String?

