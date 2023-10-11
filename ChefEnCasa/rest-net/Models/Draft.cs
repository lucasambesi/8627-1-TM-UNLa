using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;

namespace rest_net.Models
{
    public class Draft
    {
        [BsonId]
        public ObjectId Id { get; set; }

        public string? DraftId { get; set; }

        public string UserId { get; set; }

        public string Title { get; set; }

        public string Description { get; set; }

        public string Category { get; set; }

        public string PreparationTime { get; set; }
    }
}
