export JAVA_HOME='/c/Program Files (x86)/insee/atelier-dev-2/applications/jdk18_64/openjdk-1.8.0_172'
export GIT_SSH="/usr/bin/ssh.exe"
export PATH=$JAVA_HOME/bin:$PATH
export PATH=$PATH:"/c/Program Files (x86)/insee/atelier-dev-2/applications/maven/bin"
export HTTP_PROXY=http://proxy-rie.http.insee.fr:8080

mcd ()
{
    mkdir -p -- "$1" &&
      cd -P -- "$1"
}