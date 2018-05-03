function() {   
	var url = karate.properties['karate.url']
	if (!url) {
		url = 'http://localhost:8080'
	}
	karate.log('karate.url system property is:', url)
  return {
    baseUrl: url
  }
}