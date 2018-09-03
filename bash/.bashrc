export JAVA_HOME='/c/Program Files (x86)/insee/atelier-dev-2/applications/jdk18_64/jdk-1.8.0_40'
export PATH=$JAVA_HOME/bin:$PATH
export PATH=$PATH:"/c/Program Files (x86)/insee/atelier-dev-2/applications/maven/bin"
export HTTP_PROXY=http://proxy-rie.http.insee.fr:8080

mcd ()
{
    mkdir -p -- "$1" &&
      cd -P -- "$1"
}