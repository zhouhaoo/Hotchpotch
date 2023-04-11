import 'package:json_annotation/json_annotation.dart';

@JsonSerializable()
class VideoBean {
  int id = 0;
  var title = "";

  VideoBean(this.id, this.title);
}
