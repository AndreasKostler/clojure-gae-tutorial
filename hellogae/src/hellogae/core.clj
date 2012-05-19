(ns hellogae.core
  (:gen-class :extends javax.servlet.http.HttpServlet)
  (:use compojure.core
        ring.util.servlet)
  (:require [compojure.route :as route]))

(defroutes hello-gae
  (GET "/" [] "<h1> Hello GAE from Clojure!</h1>")
  (route/not-found "Page not found"))

(defservice hello-gae)

