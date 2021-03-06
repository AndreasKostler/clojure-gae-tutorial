(ns rot13.core
  (:gen-class :extends javax.servlet.http.HttpServlet)
  (:use compojure.core
        ring.util.servlet
        [ring.middleware.params :only [wrap-params]]
        net.cgrand.enlive-html)
  (:require [compojure.route :as route]))

(def page
  "<html>
  <head>
    <title>Unit 2 Rot 13</title>
  </head>

  <body>
    <h2>Enter some text to ROT13:</h2>
    <form method=\"post\">
      <textarea name=\"text\"
                style=\"height: 100px; width: 400px;\"></textarea>
      <br>
      <input type=\"submit\">
    </form>
  </body>
  </html>")

(deftemplate paget (java.io.StringReader. page) [text]
  [:form (attr= :name "text")] (content text))


(defn- char-rot13 [c]
  (if-let [_ (java.lang.Character/isLetter c)]
    (let [base (if (java.lang.Character/isUpperCase c) 65 97)]
      (char (+ (mod (+ (- (int c) base) 13) 26) base)))
    c))

(defn rot13 [text]
  (apply str (map char-rot13 text)))
 
(defroutes app
  (GET "/" [] (paget ""))
  (POST "/" [text] (paget (rot13 text)))
  (route/not-found "Page not found"))

(defservice (wrap-params app))

