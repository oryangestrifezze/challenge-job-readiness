##  Challenge Job Readiness | Projeto Integrador Android - Bootcamp Android

#### Desenvolvedora: [Oryange Strifezze](https://github.com/oryangestrifezze)

#### Este projeto foi executado de forma autonoma, com finalidade de consolidar os conhecimentos adquiridos ao longo do segundo módulo do Bootcamp de Android.

Challenge Job Readiness é um aplicativo que consome três API's do Mercado Livre e permite que o usuário realize pesquisas de items da plataforma, evidencie preços e adicione aos seus favoritos.

A aplicação foi desenvolvido com arquitetura MVVM a fim de manter um projeto de arquitetura limpa e organizada.

### Recursos utilizados
- Activity
- Fragments
- Retrofit 
- Navigation
- Shared Preferences 
- Testes unitários utilizando JUnit (Android)

### Rodar Projeto
- Clone este repositório
- Realize uma chamada para esta [API_1](https://auth.mercadolivre.com.br/authorization?response_type=code&client_id=2200225733175765&redirect_uri=https://www.alkemy.org)
- Com o Código TG da API_1, realize a chamada para a [API_2](https://api.mercadolibre.com/oauth/token?grant_type=authorization_code&client_id=2200225733175765&client_secret=f9ehl4HEVc22uLCvORQevFhmLUfudaqh&code=TG-62c0449234126f00135116e3-795944208&redirect_uri=https://www.alkemy.org)  
- Copie o Token Access e cole no InterceptorAuth deste projeto (CRepository/Data_Source) 
