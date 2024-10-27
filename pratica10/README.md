# Criptografia Simétrica em Java

Este projeto em Java demonstra a implementação da criptografia simétrica para proteger uma mensagem simples usando o algoritmo AES. O código gera uma chave secreta, criptografa uma mensagem e, em seguida, a descriptografa para exibir o texto original.

## Descrição do Projeto

O código utiliza a biblioteca `javax.crypto` para gerar uma chave AES, criptografar um texto e, em seguida, restaurá-lo ao original. A criptografia simétrica usa a mesma chave para ambos os processos de criptografia e descriptografia.

### Funcionalidades

- **Geração de Chave AES**: Usa `KeyGenerator` para criar uma chave secreta AES.
- **Criptografia**: Converte o texto em uma forma cifrada utilizando `Cipher.ENCRYPT_MODE`.
- **Descriptografia**: Restaura o texto original a partir do texto cifrado usando `Cipher.DECRYPT_MODE`.

### Como Usar

1. Compile e execute o código `criptoSimetrica.java` em um ambiente Java.
2. O programa irá:
   - Gerar uma chave AES e exibi-la em Base64.
   - Criptografar o texto `"the quick brown fox jumps over the lazy dog"` e exibir o texto cifrado em Base64.
   - Descriptografar o texto cifrado e exibir o texto original.

### Exemplo de Saída

- **Chave Gerada**: `a0B1c2D3e4F5g6H7i8J9k0L1m2N3o4P5`
- **Texto Aberto**: `the quick brown fox jumps over the lazy dog`
- **Texto Cifrado**: `YWJjZGVmZ2hpamtsbW5vcHFyc3R1dnd4eXo=`
- **Texto Recuperado**: `the quick brown fox jumps over the lazy dog`

### Tratamento de Exceções

O código trata as seguintes exceções, garantindo maior estabilidade e segurança:
- **NoSuchAlgorithmException**: Lançada caso o algoritmo AES não esteja disponível.
- **NoSuchPaddingException**: Lançada caso o padding especificado não seja suportado.
- **InvalidKeyException**: Ocorrida se a chave utilizada não for válida.
- **IllegalBlockSizeException** e **BadPaddingException**: Associadas a erros nas operações de criptografia e descriptografia.
  
### Licença

Este projeto é distribuído sob a licença MIT.
