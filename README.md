# UFRJ Turma Engsoft30 - BigData (Prof. Alexandre A. B. Lima)
O trabalho desenvolvido, é referente aos sinistros ocorridos somente na cidade do Rio de Janeiro.

O Arquivo analisado contém aproximadamente 10 mil registros.

Seguem as tecnologias, que o projeto estará utilizando :

# Play Framework : 
O Play Framework combina produtividade e desempenho, facilitando a criação de aplicativos web escaláveis com Scala.

# Apache Scala :
Spark é um sistema de computação de cluster rápido para Big Data. Ele fornece APIs de alto nível em Scala que 
suporta um conjunto rico de ferramentas de alto nível. Exemplo : Spark SQL para SQL e DataFrames.

# Resumo da Arquitetura do Projeto
O Projeto está utilizando o Play Framework. Este framework, será capaz de fazer o front-end (utilizando Html5 e Api GoogleChart) e backend (controller na linguagem Scala).

No backend, teremos um arquivo Application.scala (.\app\controllers). Neste arquivo teremos configurações do Spark (Context/Session), que irão se conectar ao spark, através da seguinte configuração do master.

 val spark = SparkSession.builder()
		  .master("<endereço do master>")
		  .appName("IncidenciasRJ")		  
		  .getOrCreate()


#Pré-Requisitos / Instalação / Configuração do Projeto

1. Fazer download e instalar o Sbt no linux (Ubuntu 16.04):  http://www.scala-sbt.org
2. Fazer download e instalar o Google Chrome : Testado com sucesso neste browser.
3. Fazer download e extrair o projeto appBigDataScala.
4. Na pasta do projeto (appBigDataScala), executar o comando sbt.
5. assim que atualizar o projeto, aparecerá o cursor >. Neste momento execute o comando run.
6. Acessar no browser o endereço http://localhost:9000
7. O projeto irá iniciar com sucesso.

Observação :
Para enviar as informações ao spark, deverá atualizar o arquivo Application.scala , onde .master("<endereço do master>") 
<endereço master> será o local onde estará configurado o SparkMaster.

Para levantar um cluster Master/Workers, acesse o endereço para maiores informações : 
https://spark.apache.org/docs/2.1.0/spark-standalone.html

Ou siga abaixo :

1. Faça download do Apache Spark  : https://spark.apache.org/downloads.html
2. Extraia o arquivo : spark-2.1.1-bin-hadoop2.7.tgz
3. No diretório sbin, execute o comando spark-master.sh 
Assim que for inicializado o Mestre, acesse o endereço http:localhost:8080
Observe que na página superior da página, terá um endereço do spark (exemplo : spark://spark:7077).
4. Configure os Workers : configure o seguinte comando :
SPARK_WORKER_MEMORY=1Gb SPARK_WORKER_INSTANCES=2 SPARK_WORKER_CORES=1 <endereco da pasta do Apache Spark>/sbin/start-slave.sh spark://spark:7077 (endereço do Mestre).

SPARK_WORKER_MEMORY    - Memória do Worker
SPARK_WORKER_INSTANCES - Quantidades de Workers
SPARK_WORKER_CORES     - Quantidade de Processadores (núcleos de processamento)

5. Após executar esses comandos , os workers irão aparecer na aba Workers (na página do Mestre), com seus respectivos ID's.
6. Após a execução da página Web, o play irá submeter as consultas ao Spark e a arquitetura em Cluster funcionando com sucesso.



