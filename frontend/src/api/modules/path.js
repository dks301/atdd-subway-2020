import ApiService from '@/api'

const PathService = {
  get(path) {
    return ApiService.get(`/paths?source=${path.source}&target=${path.target}&type=${path.type}&time=${path.time}`)
  }
}

export default PathService
