function() {   
	var url = karate.properties['karate.url']
	karate.log('karate.url system property was:', url)
	if (!url) {
		url = 'http://localhost:8080'
	}
  return {
    baseUrl: url
  }
}