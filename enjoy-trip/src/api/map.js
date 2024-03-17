import { localAxios } from "@/util/http-commons";

const local = localAxios();

function listSido(param, success, fail) {
  local.get(`/map/sido`, { params: param }).then(success).catch(fail);
}

function listGugun(param, success, fail) {
  local.get(`/map/gugun`, { params: param }).then(success).catch(fail);
}

function listAttractions(param, success, fail) {
  local.get(`/map/attractionInfo`, { params: param }).then(success).catch(fail);
}

function listContentTypeId(success, fail) {
  local.get(`/map/contentTypeId`).then(success).catch(fail);
}

export { listSido, listGugun, listAttractions, listContentTypeId };
