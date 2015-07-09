##Douglas Ritter - Assignment

Para a execução do projeto, foi utilizada a arquitetura Model-View-Presenter, conforme a imagem abaixo.
A ideia é combater um problema comum no Android, que é colocar muita lógica nas activities.
O json de detalhe está sendo buscado propositalmente, para aproveitar a arquitetura. Fiz isso sabendo que o json da lista traz os detalhes do post.
Referência para a arquitetura utilizada: http://saulmm.github.io/2015/02/02/A%20useful%20stack%20on%20android%20%231,%20architecture/

![alt tag](https://bytebucket.org/douglasritter/netshoes/raw/abc2e813a9cc193b30814e857ed2a5ecc0a2aebf/architecture.png?token=f49e5a45f3f2d2cdc5b0213c52adefe9144879ef)

Foram utilizadas libs para comunicação com o servidor, para o parse do json, para mascarar a imagem do profile e para os testes unitários.
Foi implementado teste de interface, mas a API necessária é a 18 para o UI Automator, então optei por retirar (o histórico está no git).

Criei algumas imagens com base no mockup, para o placeholder e para os ícones de share.
A barra abaixo do nome e os likes foi feita com gradiente.
As cores utilizadas no tema foram criadas em https://www.materialpalette.com/green/deep-orange.

Abaixo, um vídeo da execução do app:
![alt tag](https://bytebucket.org/douglasritter/netshoes/raw/a634949d21cdcd60d4235017cb8442bb61df92b8/DouglasNetshoes.gif?token=e884ad4d2297259656254d5f6312cd3d64458630)
