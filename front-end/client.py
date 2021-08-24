from flask import Flask,render_template
import requests

app=Flask(__name__,template_folder='templates')

@app.route("/")
def home():
    return render_template('index.html')

@app.route("/paymentdetails")
def paymentdetails():
    r = requests.get(url="http://localhost:8080/paymenthistory/paymentDetails")
    return render_template('paymentDetails.html')

@app.route("/payments")
def payments():
    r = requests.get(url="http://localhost:8080/paymenthistory/payments")
    return render_template('payments.html')

@app.route("/itemDetails")
def itemDetails():
    return render_template('itemDetails.html')

@app.route("/catalog")
def about():
    r = requests.get(url="http://localhost:8080/catalog")
    data = r.json()
    return render_template('catalog.html', catalogItems = data)

if __name__=="__main__":
    app.run(debug=True)
