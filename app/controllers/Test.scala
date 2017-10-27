package controllers

import javax.inject.Inject

import play.api.mvc.ControllerComponents

import play.api.mvc.AbstractController

import play.api.libs.json.Json

class Test @Inject()(cc: ControllerComponents)
  extends AbstractController(cc) {

    def test = Action {
      Ok(
        Json.obj(
          "status" -> "OK",
          "message" -> "it works"
        )
      )
    }
}
