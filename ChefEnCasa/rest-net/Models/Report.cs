using MongoDB.Bson.Serialization.Attributes;
using MongoDB.Bson;
using rest_net.Models.Enums;

namespace rest_net.Models
{
    public class Report
    {
        [BsonId]
        public ObjectId Id { get; set; }

        public string? ReportId { get; set; }

        public string UserId { get; set; }

        public string RecipeId { get; set; }

        public ReportType Type { get; set; }

        public string? Comment { get; set; }

        public bool? Resolved { get; set; } = false;
    }
}
