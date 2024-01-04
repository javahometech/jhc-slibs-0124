def call(tomcatIp,userName,credId,warName){
  sshagent([credId]) {
    sh "scp -o StrictHostKeyChecking=no target/${warName} ${userName}@${tomcatIp}:/opt/tomcat9/webapps/"
    sh "ssh ${userName}@${tomcatIp} /opt/tomcat9/bin/shutdown.sh"
    sh "ssh ${userName}@${tomcatIp} /opt/tomcat9/bin/startup.sh"
  }
}
